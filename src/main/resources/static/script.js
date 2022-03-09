const catsList = document.querySelector('.cats-list');
const addCatForm = document.querySelector('.add-cat-form');
const nameValue = document.getElementById('name-value');
const breedValue = document.getElementById('breed-value');
const ageValue = document.getElementById('age-value');

let output = '';

const renderCat = (cats) => {
    cats.forEach(cat => {
        output += `
          <div class="card mt-4 col-md-6 bg-ligt">
          <div class="card-body" cat-id=${cat.id}>
            <h5 class="card-title">Cat Name : ${cat.name}</h5>
            <h5 class="card-title">Cat Breed : ${cat.breed}</h5>
            <h5 class="card-title">Cat Age: ${cat.age}</h5>
            <a href="#" class="card-link" id="edit-cat">Edit</a>
            <a href="#" class="card-link" id="delete-cat">Delete</a>
          </div>
        </div>
          `;
      });
      catsList.innerHTML = output;
}

const url = 'http://localhost:8080/getAll';

fetch(url)
  .then((res) => res.json())
  .then(data => renderCat(data));

  catsList.addEventListener('click', (f) => {
      f.preventDefault();
      let editButtonClicked = f.target.id == 'edit-cat';
      let deleteButtonClicked = f.target.id == 'delete-cat';
      let id = f.target.parentElement.dataset.id;

    if(deleteButtonClicked) {
        fetch('http://localhost:8080/remove/' + parseInteger(id), {
            method: 'DELETE',
        })
        .then(res => res.json())
        .then(() => location.reload())
    }
  })

  addCatForm.addEventListener('submit', (f) => {
    f.preventDefault();
    fetch('http://localhost:8080/create', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            name: nameValue.value,
            breed: breedValue.value,
            age: ageValue.value
        })
    })
    .then(res => res.json())
    .then(data => {
        const dataArr = [];
        dataArr.push(data);
        renderCat(dataArr);
    })
  })