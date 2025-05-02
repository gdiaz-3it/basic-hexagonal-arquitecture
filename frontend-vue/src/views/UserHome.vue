<template>
  <div class="home-container">
    <h1>Lista de tritianos</h1>

    <!-- Tabla de estudiantes -->
    <table class="items-table">
      <thead>
        <tr>
          <th>Nombre</th>
          <th>Apellido</th>
          <th>Correo Electronico</th>
          <th>Rut</th>
          <th>Telefono</th>
          <th>Estado</th>
          <th>Enlace Bizneo</th>
          <th>Enlace HubSpot</th>
          <th>Enlace Jira</th>
          <th>Acciones</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="tritianos in paginatedtritianos" :key="tritianos.id">
          <td>{{ tritianos.nombre }}</td>
          <td>{{ tritianos.apellido }}</td>
          <td>{{ tritianos.correoElectronico }}</td>
          <td>{{ tritianos.rut }}</td>
          <td>{{ tritianos.telefono }}</td>
          <td>{{ tritianos.estado }}</td>
          <td>{{ tritianos.enlaceBizneo }}</td>
          <td>{{ tritianos.enlaceHubspot }}</td>
          <td>{{ tritianos.enlaceJira }}</td>
          <td class="actions-container">
            <button @click="toggleDropdown(tritianos.id)" class="btn-actions">
              Acciones
            </button>
            <div v-if="openDropdown === tritianos.id" class="dropdown-menu">
              <button @click="edittritiano(tritianos)" class="dropdown-item">
                Editar
              </button>
              <button @click="deletetritiano(tritianos.id)" class="dropdown-item cancel-delete">
                Eliminar
              </button>
            </div>
          </td>
        </tr>
      </tbody>
    </table>

    <div v-if="editingtritiano" class="form-container">
      <h2>Editar tritiano</h2>
      <form @submit.prevent="updatetritiano">
        <div class="form-field">
          <label for="nombre">Nombre:</label>
          <input type="text" v-model="editingtritiano.nombre" required />
        </div>
        <div class="form-field">
          <label for="apellido">Apellido:</label>
          <input type="text" v-model="editingtritiano.apellido" required />
        </div>
        <div class="form-field">
          <label for="correo">Correo Electrónico:</label>
          <input type="email" v-model="editingtritiano.correoElectronico" required />
        </div>
        <div class="form-field">
          <label for="rut">Rut:</label>
          <input type="text" v-model="editingtritiano.rut" required />
        </div>
        <div class="form-field">
          <label for="telefono">Teléfono:</label>
          <input type="text" v-model="editingtritiano.telefono" required />
        </div>
        <div class="form-field">
          <label for="estado">Estado:</label>
          <select v-model="editingtritiano.estado" required>
            <option value="Activo">Activo</option>
            <option value="Inactivo">Inactivo</option>
          </select>
        </div>
        <div class="form-field">
          <label for="bizneo">Enlace Bizneo:</label>
          <input type="url" v-model="editingtritiano.enlaceBizneo" required />
        </div>
        <div class="form-field">
          <label for="hubspot">Enlace HubSpot:</label>
          <input type="url" v-model="editingtritiano.enlaceHubspot" required />
        </div>
        <div class="form-field">
          <label for="hubspot">Enlace Jira:</label>
          <input type="url" v-model="editingtritiano.enlaceJira" required />
        </div>
        <div class="button-container">
          <button type="submit">Actualizar</button>
          <button class="cancel-delete" @click="cancelEdit">Cancelar</button>
        </div>
      </form>
    </div>

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
      <form @submit.prevent="addtritiano">
        <div class="form-field">
          <label for="nombre">Nombre:</label>
          <input type="text" id="name" v-model="newtritiano.nombre" required />
        </div>
        <div class="form-field">
          <label for="apellido">Apellido:</label>
          <input type="text" id="apellido" v-model="newtritiano.apellido" required />
        </div>
        <div class="form-field">
          <label for="correo">Correo Electrónico:</label>
          <input type="email" id="correo" v-model="newtritiano.correoElectronico" required />
        </div>
        <div class="form-field">
          <label for="rut">Rut:</label>
          <input type="text" id="rut" v-model="newtritiano.rut" required />
        </div>
        <div class="form-field">
          <label for="telefono">Teléfono:</label>
          <input type="text" id="telefono" v-model="newtritiano.telefono" required />
        </div>
        <div class="form-field">
          <label for="estado">Estado:</label>
          <select v-model="newtritiano.estado" required>
            <option value="Activo">Activo</option>
            <option value="Inactivo">Inactivo</option>
            <option value="En Proceso">En Proceso</option>
          </select>
        </div>
        <div class="form-field">
          <label for="bizneo">Enlace Bizneo:</label>
          <input type="url" id="bizneo" v-model="newtritiano.enlaceBizneo" required />
        </div>
        <div class="form-field">
          <label for="hubspot">Enlace Hubspot:</label>
          <input type="url" id="hubspot" v-model="newtritiano.enlaceHubspot" required />
        </div>
        <div class="form-field">
          <label for="jira">Enlace Jira:</label>
          <input type="url" id="jira" v-model="newtritiano.enlaceJira" required />
        </div>
        <div class="button-container">
          <button type="submit">Agregar Estudiante</button>
        </div>
      </form>
    </div>

    <div v-if="message" :class="['message', messageType]">{{ message }}</div>
  </div>
</template>

<script>
import axios from "axios";
import { ref, computed, onMounted } from "vue";

export default {
  name: "UserHome",
  setup() {
    const openDropdown = ref(null);
    const tritianos = ref([]);
    const editingtritiano = ref(null);
    const newtritiano = ref({
      nombre: "",
      apellido: "",
      correoElectronico: "",
      rut: "",
      telefono: "",
      estado: "",
      enlaceBizneo: "",
      enlaceHubspot: "",
      enlaceJira: "",
    });
    const elementsPerPage = 4;
    const currentPage = ref(1);
    const message = ref("");
    const messageType = ref("");

    const toggleDropdown = (id) => {
      openDropdown.value = openDropdown.value === id ? null : id;
    };

    const cancelEdit = () => {
      editingtritiano.value = null;
    };

    const fetchtritianos = async () => {
      try {
        const response = await axios.get(
          "http://localhost:8081/api/tritianos",);
        console.log("tritianos recibidos:", response.data);
        tritianos.value = response.data;
      } catch (error) {
        console.error("Error al obtener tritianos:", error);
        message.value = "Error al cargar los tritianos.";
        messageType.value = "error";
      }
    };

    const addtritiano = async () => {
      message.value = "";
      try {
        const response = await axios.post("http://localhost:8081/api/tritianos", newtritiano.value);
        tritianos.value.push(response.data);
        newtritiano.value = {
          nombre: "",
          apellido: "",
          correoElectronico: "",
          rut: "",
          telefono: "",
          estado: "",
          enlaceBizneo: "",
          enlaceHubspot: "",
          enlaceJira: "",
        };
        message.value = "tritiano agregado con éxito.";
        messageType.value = "success";

        setTimeout(() => {
          message.value = "";
        }, 2500);
      } catch (error) {
        console.error("Error al agregar tritiano:", error);
        message.value = "Error al agregar el tritiano.";
        messageType.value = "error";
      }
    };

    const deletetritiano = async (id) => {
      if (!confirm("¿Estás seguro de que deseas eliminar este tritiano?")) return;

      try {
        await axios.delete(`http://localhost:8081/api/tritianos/${id}`);
        tritianos.value = tritianos.value.filter(t => t.id !== id);
        message.value = "tritiano eliminado correctamente.";
        messageType.value = "success";

        setTimeout(() => {
          message.value = "";
        }, 2500);
      } catch (error) {
        console.error("Error al eliminar tritiano:", error);
        message.value = "Error al eliminar el tritiano.";
        messageType.value = "error";
      }
    };

    const edittritiano = (tritiano) => {
      openDropdown.value = null;
      editingtritiano.value = { ...tritiano };
    };

    const updatetritiano = async () => {
      try {
        await axios.patch(`http://localhost:8081/api/tritianos/${editingtritiano.value.id}`, editingtritiano.value);
        const index = tritianos.value.findIndex(t => t.id === editingtritiano.value.id);
        if (index !== -1) {
          tritianos.value[index] = { ...editingtritiano.value };
        }
        editingtritiano.value = null;
      } catch (error) {
        console.error("Error al actualizar tritiano:", error);
      }
    };

    const totalPages = computed(() =>
      Math.ceil(tritianos.value.length / elementsPerPage)
    );

    const paginatedtritianos = computed(() => {
      const start = (currentPage.value - 1) * elementsPerPage;
      return tritianos.value.slice(start, start + elementsPerPage);
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

    onMounted(() => {
      fetchtritianos();
    });

    return {
      openDropdown,
      toggleDropdown,
      cancelEdit,
      tritianos,
      newtritiano,
      editingtritiano,
      paginatedtritianos,
      currentPage,
      totalPages,
      nextPage,
      previousPage,
      fetchtritianos,
      addtritiano,
      edittritiano,
      updatetritiano,
      deletetritiano,
      message,
      messageType
    };
  },
};
</script>
