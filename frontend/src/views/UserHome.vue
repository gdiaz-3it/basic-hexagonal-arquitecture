<template>
  <div class="home-container">
    <h1>Lista de Trinitianos</h1>

    <!-- Tabla de estudiantes -->
    <table class="items-table">
      <thead>
        <tr>
          <th>ID</th>
          <th>Nombre</th>
          <th>Apellido</th>
          <th>Correo Electronico</th>
          <th>Telefono</th>
          <th>Estado</th>
          <th>Enlace Bizneo</th>
          <th>Enlace HubSpot</th>
          <th>Enlace Jira</th>
          <th>Fecha Creacion</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="student in paginatedStudents" :key="student.studentId">
          <td>{{ student.studentId }}</td>
          <td>{{ student.name }}</td>
          <td>{{ student.surname }}</td>
          <td>{{ student.career.name }}</td>
        </tr>
      </tbody>
    </table>

    <!-- Paginación -->
    <div class="pagination">
      <button @click="previousPage" :disabled="currentPage === 1">
        Anterior
      </button>
      <span>Página {{ currentPage }} de {{ totalPages }}</span>
      <button @click="nextPage" :disabled="currentPage === totalPages">
        Siguiente
      </button>
    </div>

    <!-- Formulario para agregar estudiante -->
    <div class="form-container">
      <h2>Agregar Estudiante</h2>
      <form @submit.prevent="addStudent">
        <div class="form-field">
          <label for="name">Nombre:</label>
          <input type="text" id="name" v-model="newStudent.name" required />
        </div>
        <div class="form-field">
          <label for="surname">Apellido:</label>
          <input type="text" id="surname" v-model="newStudent.surname" required />
        </div>
        <div class="form-field">
          <label for="career">Carrera:</label>
          <select v-model="newStudent.careerName" required>
            <option disabled value="">Selecciona una carrera</option>
            <option v-for="career in courses" :key="career.careerId" :value="career.name">
              {{ career.name }}
            </option>
          </select>
        </div>
        <div class="button-container">
          <button type="submit">Agregar Estudiante</button>
        </div>
      </form>
    </div>

     <!-- Botón de Logout -->
     <div class="logout-container">
      <button @click="logout">Cerrar Sesión</button>
    </div>

    <div v-if="message" :class="['message', messageType]">{{ message }}</div>
  </div>
</template>

<script>
import axios from "axios";
import { ref, computed, onMounted } from "vue";
import { useRouter } from "vue-router";

export default {
  name: "UserHome",
  setup() {
    const students = ref([]);
    const courses = ref([]);
    const newStudent = ref({
      name: "",
      surname: "",
      careerName: "",
    });
    const elementsPerPage = 4;
    const currentPage = ref(1);
    const message = ref("");
    const messageType = ref("");

    const router = useRouter();

    const fetchStudents = async () => {
      try {
        const response = await axios.get(
          "http://localhost:8095/api/estudiantes",);
        console.log("Estudiantes recibidos:", response.data);
        students.value = response.data;
      } catch (error) {
        console.error("Error al obtener estudiantes:", error);
        message.value = "Error al cargar los estudiantes.";
        messageType.value = "error";
      }
    };

    const fetchCourses = async () => {
      try {
        const response = await axios.get(
          "http://localhost:8095/api/carreras",);
        courses.value = response.data;
      } catch (error) {
        console.error("Error al obtener carreras:", error);
        message.value = "Error al cargar las carreras.";
        messageType.value = "error";
      }
    };

    const addStudent = async () => {
      message.value = "";
      if (!newStudent.value.careerName) {
        message.value = "Por favor, selecciona una carrera.";
        messageType.value = "error";
        return;
      }

      const selectedCareer = courses.value.find(
        (career) => career.name === newStudent.value.careerName
      );

      if (!selectedCareer) {
        message.value = "Carrera no encontrada.";
        messageType.value = "error";
        return;
      }

      try {
        const response = await axios.post(
          "http://localhost:8095/api/estudiantes/agregar",
          {
            name: newStudent.value.name,
            surname: newStudent.value.surname,
            careerId: selectedCareer.careerId,
          }
        );

        students.value.push(response.data);
        newStudent.value = { name: "", surname: "", careerName: "" };
        message.value = "Estudiante agregado con éxito.";
        messageType.value = "success";

        setTimeout(() => {
          message.value = "";
        }, 2500);
      } catch (error) {
        console.error("Error al agregar estudiante:", error);
        message.value = "Error al agregar el estudiante.";
        messageType.value = "error";
      }
    };

    const totalPages = computed(() =>
      Math.ceil(students.value.length / elementsPerPage)
    );

    const paginatedStudents = computed(() => {
      const start = (currentPage.value - 1) * elementsPerPage;
      return students.value.slice(start, start + elementsPerPage);
    });

    const nextPage = () => {
      if (currentPage.value < totalPages.value) {
        currentPage.value++;
      }
    };

    const previousPage = () => {
      if (currentPage.value > 1) {
        currentPage.value--;
      }
    };

    const logout = () => {
      router.push("/login");
    };

    onMounted(async () => {
      await Promise.all([fetchStudents(), fetchCourses()]);
    });

    return {
      students,
      courses,
      newStudent,
      paginatedStudents,
      currentPage,
      totalPages,
      nextPage,
      previousPage,
      addStudent,
      message,
      messageType,
      logout,
    };
  },
};
</script>

<style scoped>
.home-container {
  text-align: center;
  margin-top: 50px;
}

.logout-container {
  margin-bottom: 20px;
  text-align: center;
}

.logout-container button {
  padding: 8px 15px;
  background-color: #dc3545;
  color: white;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}

.logout-container button:hover {
  background-color: #c82333;
}

.items-table {
  margin: 20px auto;
  width: 40%;
  border-collapse: collapse;
  text-align: left;
}

.items-table th,
.items-table td {
  border: 1px solid #ddd;
  padding: 10px;
}

.items-table th {
  background-color: #f4f4f4;
}

.pagination {
  margin-top: 20px;
}

.pagination button {
  margin: 0 10px;
  padding: 5px 10px;
}

.error {
  color: red;
  font-size: 12px;
}

.input-error {
  border-color: red;
}

.form-container {
  margin-top: 30px;
  text-align: left;
  max-width: 400px;
  margin: 30px auto;
}

.form-field {
  margin-bottom: 15px;
  display: flex;
  align-items: center;
}

.message {
  margin: 10px 0;
  padding: 10px;
  border-radius: 5px;
  text-align: center;
}

.success {
  background-color: #d4edda;
  color: #155724;
  border: 1px solid #c3e6cb;
}

.error {
  background-color: #f8d7da;
  color: #721c24;
  border: 1px solid #f5c6cb;
}
.form-container h2 {
  text-align: center;
}
.button-container {
  display: flex;
  justify-content: center;
  margin-top: 15px;
}

label {
  margin-right: 15px;
  min-width: 150px;
}

input,
select {
  flex-grow: 1;
  padding: 8px;
  box-sizing: border-box;
}

button {
  padding: 8px 15px;
  background-color: #007bff;
  color: white;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}

button:hover {
  background-color: #0056b3;
}
</style>
