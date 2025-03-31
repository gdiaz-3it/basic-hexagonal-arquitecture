<template>
  <div class="home-container">
    <h1>Lista de Trinitianos</h1>

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
        <tr v-for="trinitianos in paginatedTrinitianos" :key="trinitianos.id">
          <td>{{ trinitianos.nombre }}</td>
          <td>{{ trinitianos.apellido }}</td>
          <td>{{ trinitianos.correoElectronico }}</td>
          <td>{{ trinitianos.rut }}</td>
          <td>{{ trinitianos.telefono }}</td>
          <td>{{ trinitianos.estado }}</td>
          <td>{{ trinitianos.enlaceBizneo }}</td>
          <td>{{ trinitianos.enlaceHubspot }}</td>
          <td>{{ trinitianos.enlaceJira }}</td>
          <td class="actions-container">
            <button @click="toggleDropdown(trinitianos.id)" class="btn-actions">
              Acciones
            </button>
            <div v-if="openDropdown === trinitianos.id" class="dropdown-menu">
              <button @click="editTrinitiano(trinitianos)" class="dropdown-item">
                Editar
              </button>
              <button @click="deleteTrinitiano(trinitianos.id)" class="dropdown-item cancel-delete">
                Eliminar
              </button>
            </div>
          </td>
        </tr>
      </tbody>
    </table>

    <div v-if="editingTrinitiano" class="form-container">
      <h2>Editar Trinitiano</h2>
      <form @submit.prevent="updateTrinitiano">
        <div class="form-field">
          <label for="nombre">Nombre:</label>
          <input type="text" v-model="editingTrinitiano.nombre" required />
        </div>
        <div class="form-field">
          <label for="apellido">Apellido:</label>
          <input type="text" v-model="editingTrinitiano.apellido" required />
        </div>
        <div class="form-field">
          <label for="correo">Correo Electrónico:</label>
          <input type="email" v-model="editingTrinitiano.correoElectronico" required />
        </div>
        <div class="form-field">
          <label for="rut">Rut:</label>
          <input type="text" v-model="editingTrinitiano.rut" required />
        </div>
        <div class="form-field">
          <label for="telefono">Teléfono:</label>
          <input type="text" v-model="editingTrinitiano.telefono" required />
        </div>
        <div class="form-field">
          <label for="estado">Estado:</label>
          <select v-model="editingTrinitiano.estado" required>
            <option value="Activo">Activo</option>
            <option value="Inactivo">Inactivo</option>
          </select>
        </div>
        <div class="form-field">
          <label for="bizneo">Enlace Bizneo:</label>
          <input type="url" v-model="editingTrinitiano.enlaceBizneo" required />
        </div>
        <div class="form-field">
          <label for="hubspot">Enlace HubSpot:</label>
          <input type="url" v-model="editingTrinitiano.enlaceHubspot" required />
        </div>
        <div class="form-field">
          <label for="hubspot">Enlace Jira:</label>
          <input type="url" v-model="editingTrinitiano.enlaceJira" required />
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
          <input type="email" id="correo" v-model="newTrinitiano.correoElectronico" required />
        </div>
        <div class="form-field">
          <label for="rut">Rut:</label>
          <input type="text" id="rut" v-model="newTrinitiano.rut" required />
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
          <input type="url" id="bizneo" v-model="newTrinitiano.enlaceBizneo" required />
        </div>
        <div class="form-field">
          <label for="hubspot">Enlace Hubspot:</label>
          <input type="url" id="hubspot" v-model="newTrinitiano.enlaceHubspot" required />
        </div>
        <div class="form-field">
          <label for="jira">Enlace Jira:</label>
          <input type="url" id="jira" v-model="newTrinitiano.enlaceJira" required />
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
    const trinitianos = ref([]);
    const editingTrinitiano = ref(null);
    const newTrinitiano = ref({
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
      editingTrinitiano.value = null;
    };

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
          correoElectronico: "",
          rut: "",
          telefono: "",
          estado: "",
          enlaceBizneo: "",
          enlaceHubspot: "",
          enlaceJira: "",
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

    const deleteTrinitiano = async (id) => {
      if (!confirm("¿Estás seguro de que deseas eliminar este trinitiano?")) return;

      try {
        await axios.delete(`http://localhost:8081/api/trinitianos/${id}`);
        trinitianos.value = trinitianos.value.filter(t => t.id !== id);
        message.value = "Trinitiano eliminado correctamente.";
        messageType.value = "success";

        setTimeout(() => {
          message.value = "";
        }, 2500);
      } catch (error) {
        console.error("Error al eliminar trinitiano:", error);
        message.value = "Error al eliminar el trinitiano.";
        messageType.value = "error";
      }
    };

    const editTrinitiano = (trinitiano) => {
      openDropdown.value = null;
      editingTrinitiano.value = { ...trinitiano };
    };

    const updateTrinitiano = async () => {
      try {
        await axios.patch(`http://localhost:8081/api/trinitianos/${editingTrinitiano.value.id}`, editingTrinitiano.value);
        const index = trinitianos.value.findIndex(t => t.id === editingTrinitiano.value.id);
        if (index !== -1) {
          trinitianos.value[index] = { ...editingTrinitiano.value };
        }
        editingTrinitiano.value = null;
      } catch (error) {
        console.error("Error al actualizar trinitiano:", error);
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

    onMounted(() => {
      fetchTrinitianos();
    });

    return {
      openDropdown,
      toggleDropdown,
      cancelEdit,
      trinitianos,
      newTrinitiano,
      editingTrinitiano,
      paginatedTrinitianos,
      currentPage,
      totalPages,
      nextPage,
      previousPage,
      fetchTrinitianos,
      addTrinitiano,
      editTrinitiano,
      updateTrinitiano,
      deleteTrinitiano,
      message,
      messageType
    };
  },
};
</script>
