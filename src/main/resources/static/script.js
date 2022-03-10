"use strict";

const selectAllCats = document.querySelector("#showAllCatDataPara");
let updateId = 0;

let getCats = async () => {
  let response = await fetch("http://localhost:8080/getAll");
  if (response.status !== 200) {
    throw new Error("Request has failed!");
  }
  console.log("Request Successful");
  let jsonData = await response.json();
  console.log(jsonData);
  return jsonData;
};

let showCats = async () => {
  let returnedData = await getCats();
  selectAllCats.innerHTML = "";
  returnedData.forEach(printCats);
};

function printCats(value) {
  let div = document.createElement("div");
  div.innerHTML = `
    <div class="card mt-4 col-md-6 bg-ligt">
    <div class="card-body" cat-id=${value.id}>
      <h5 class="card-title">Cat Name: ${value.name}</h5>
      <h5 class="card-title">Cat Breed: ${value.breed}</h5>
      <h5 class="card-title">Cat Age: ${value.age}</h5>
      <a href="#" class="card-link" id="edit-cat" onclick="showUpdate(${value.id})">Edit</a>
      <a href="#" class="card-link" id="delete-cat" onclick="deleteCat(${value.id})" >Delete</a>
    </div>
  </div>
       `;
  selectAllCats.append(div);
}

let createCat = async () => {
  fetch("http://localhost:8080/create", {
    method: "post",
    headers: {
      "Content-type": "application/json",
    },
    body: JSON.stringify({
      name: catName.value,
      breed: catBreed.value,
      age: catAge.value,
    }),
  })
    .then((res) => res.json())
    .then((data) => console.log(`Request succeeded with JSON response ${data}`))
    .catch((error) => console.log(`Request failed ${error}`));

  showCats;
};

function getCatById() {
  let catIds = document.getElementById("catId").value;
  fetch("/get/" + catIds)
    .then((response) => {
      if (response.status == 200) {
        return response.json();
      } else {
        alert("ID doesn't exist");
      }
    })
    .then((data) =>
      alert(
        `ID: ${data.id}, Name: ${data.name}, Breed: ${data.breed}, Age: ${data.age}`
      )
    );
}

function saveUpdate() {
  fetch("http://localhost:8080/replace/" + updateId, {
    method: "put",
    headers: {
      "Content-type": "application/json",
    },
    body: JSON.stringify({
      name: updateName.value,
      breed: updateBreed.value,
      age: updateAge.value,
    }),
  })
    .then((res) => res.json())
    .then((data) => console.log(`Request succeeded with JSON response ${data}`))
    .catch((error) => console.log(`Request failed ${error}`));
}

function deleteCat(id) {
  fetch("http://localhost:8080/remove/" + id, {
    method: "delete",
  })
    .then((data) => {
      console.log(`Request succeeded with JSON response ${data}`);
    })
    .catch((error) => {});
}

function showUpdate(id) {
  updateId = id;
  updateCatList.style.visibility = "visible";
}

function cancelUpdate() {
  updateCatList.style.visibility = "hidden";
}
