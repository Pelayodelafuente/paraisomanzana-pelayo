
// Recogemos el parámetro de la URL
const param = new URLSearchParams(window.location.search);
const idfinca = param.get("idfinca");



// Función para obtener los datos de los árboles
async function obtenerDatosArboles() {
  //const response = await fetch(`http://localhost:8080/fincas/plano/${idfinca}`);
  const response = await fetch(`http://www.paraisomanzana.es/fincas/plano/${idfinca}`);
  const datos = await response.json();
  mostrarDatosArboles(datos);
}



// Función para mostrar los datos de los árboles
function mostrarDatosArboles(datos) {
  const contenedor = document.querySelector(".contenedor");
  contenedor.innerHTML = "";
  contenedor.style.display = "grid";

  let maxColumna = 8;
  let maxFila = 8;



// Cuando se inserta un árbol fuera de los limites maximos de columna y fila, se agrandará la cuadrícula
for (let dato of datos) {
  if (dato.columna > maxColumna) {
    maxColumna = dato.columna;
  }
  if (dato.fila > maxFila) {
    maxFila = dato.fila;
  }
}
  
  
  
// Crear las celdas de la cuadrícula
for (let fila = 1; fila <= maxFila; fila++) {
  for (let columna = 1; columna <= maxColumna; columna++) {
    const cuadricula = document.createElement("div");
    cuadricula.classList.add("cuadricula");
    contenedor.appendChild(cuadricula);
    cuadricula.style.gridRow = (-fila.toString());
    cuadricula.style.gridColumn = columna.toString();
    cuadricula.addEventListener("click", () => {
      window.location.href = `../arboles/planoforminsertar?filax=${fila}&columnax=${columna}&idfincax=${idfinca}`;
    });
  }
}



// Colocar los árboles en las celdas correspondientes
for (let arbol of datos) {
  const arbolElemento = document.createElement("div");
  arbolElemento.classList.add("arbol");

  switch (arbol.estado.toUpperCase()) {
    case "MUERTO":
      arbolElemento.style.backgroundColor = "black";
      break;
    case "SANO":
      arbolElemento.style.backgroundColor = "green";
      break;
    case "ENFERMO":
      arbolElemento.style.backgroundColor = "orange";
      break;
  }
  arbolElemento.style.gridRow = (-arbol.fila.toString());
  arbolElemento.style.gridColumn = arbol.columna.toString();

  arbolElemento.dataset.idArbol = arbol.idarbol;

  arbolElemento.addEventListener("click", () => {
    const idArbol = arbolElemento.dataset.idArbol;
    window.location.href = `../arboles/formmodificar?idarbol=${idArbol}`;
  });

  contenedor.appendChild(arbolElemento);
}

}

obtenerDatosArboles();