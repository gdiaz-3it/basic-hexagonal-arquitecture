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
        <tr v-for="trinitianos in paginatedTrinitianos" :key="trinitianos.id">
          <td>{{ trinitianos.id }}</td>
          <td>{{ trinitianos.nombre }}</td>
          <td>{{ trinitianos.apellido }}</td>
          <td>{{ trinitianos.correo_electronico }}</td>
          <td>{{ trinitianos.telefono }}</td>
          <td>{{ trinitianos.estado }}</td>
          <td>{{ trinitianos.enlace_bizneo }}</td>
          <td>{{ trinitianos.enlace_hubspot }}</td>
          <td>{{ trinitianos.enlace_jira }}</td>
          <td>{{ trinitianos.fecha_creacion }}</td>
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
      <h2>Agregar Tritiano</h2>
      <form @submit.prevent="addTrinitiano">
        <div class="form-field">
          <label for="nombre">Nombre:</label>
          <input type="text" id="name" v-model="newTrinitiano.nombre" required />
        </div>
        <div class="form-field">
          <label for="apellido">Apellido:</label>
          <input type="text" id="apellido" v-model="newTrinitiano.apellido" required />
        </div>
        <div class="form-field">
          <label for="correo">Correo Electrónico:</label>
          <input type="email" id="correo" v-model="newTrinitiano.correo_electronico" required />
        </div>
        <div class="form-field">
          <label for="telefono">Teléfono:</label>
          <input type="text" id="telefono" v-model="newTrinitiano.telefono" required />
        </div>
        <div class="form-field">
          <label for="estado">Estado:</label>
          <select v-model="newTrinitiano.estado" required>
            <option value="Activo">Activo</option>
            <option value="Inactivo">Inactivo</option>
          </select>
        </div>
        <div class="form-field">
          <label for="bizneo">Enlace Bizneo:</label>
          <input type="url" id="bizneo" v-model="newTrinitiano.enlace_bizneo" required />
        </div>
        <div class="form-field">
          <label for="hubspot">Enlace Hubspot:</label>
          <input type="url" id="hubspot" v-model="newTrinitiano.enlace_hubspot" required />
        </div>
        <div class="form-field">
          <label for="jira">Enlace Jira:</label>
          <input type="url" id="jira" v-model="newTrinitiano.enlace_jira" required />
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
    const trinitianos = ref([]);
    const newTrinitiano = ref({
      nombre: "",
      apellido: "",
      correo_electronico: "",
      telefono: "",
      estado: "",
      enlace_bizneo: "",
      enlace_hubspot: "",
      enlace_jira: "",
    });
    const elementsPerPage = 4;
    const currentPage = ref(1);
    const message = ref("");
    const messageType = ref("");

    const router = useRouter();

    const fetchTrinitianos = async () => {
      try {
        const response = await axios.get(
          "http://localhost:8081/api/trinitianos",);
        console.log("Trinitianos recibidos:", response.data);
        trinitianos.value = response.data;
      } catch (error) {
        console.error("Error al obtener trinitianos:", error);
        message.value = "Error al cargar los trinitianos.";
        messageType.value = "error";
      }
    };

    const addTrinitiano = async () => {
      message.value = "";
      try {
        const response = await axios.post("http://localhost:8081/api/trinitianos", newTrinitiano.value);
        trinitianos.value.push(response.data);
        newTrinitiano.value = {
          nombre: "",
          apellido: "",
          correo_electronico: "",
          telefono: "",
          estado: "",
          enlace_bizneo: "",
          enlace_hubspot: "",
          enlace_jira: "",
        };
        message.value = "Trinitiano agregado con éxito.";
        messageType.value = "success";

        setTimeout(() => {
          message.value = "";
        }, 2500);
      } catch (error) {
        console.error("Error al agregar trinitiano:", error);
        message.value = "Error al agregar el trinitiano.";
        messageType.value = "error";
      }
    };

    const totalPages = computed(() =>
      Math.ceil(trinitianos.value.length / elementsPerPage)
    );

    const paginatedTrinitianos = computed(() => {
      const start = (currentPage.value - 1) * elementsPerPage;
      return trinitianos.value.slice(start, start + elementsPerPage);
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

    onMounted(() => {
      fetchTrinitianos();
    });

    return {
      trinitianos,
      newTrinitiano,
      paginatedTrinitianos,
      currentPage,
      totalPages,
      nextPage,
      previousPage,
      addTrinitiano,
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
