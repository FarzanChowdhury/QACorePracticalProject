var selectedRow = null;

function onFormSubmit() {
  var formData = readFormData();
  if (selectedRow == null) insertNewRecord(formData);
  else updateRecord(formData);
  resetForm();
}

function readFormData() {
  var formData = {};
  formData["id"] = document.getElementById("id").value;
  formData["catName"] = document.getElementById("catName").value;
  formData["CatBreed"] = document.getElementById("CatBreed").value;
  formData["catAge"] = document.getElementById("catAge").value;
  return formData;
}

function insertNewRecord(data) {
  var table = document
    .getElementById("catList")
    .getElementsByTagName("tbody")[0];
  var newRow = table.insertRow(table.length);
  cell1 = newRow.insertCell(0);
  cell1.innerHTML = data.id;
  cell2 = newRow.insertCell(1);
  cell2.innerHTML = data.catName;
  cell3 = newRow.insertCell(2);
  cell3.innerHTML = data.CatBreed;
  cell4 = newRow.insertCell(3);
  cell4.innerHTML = data.catAge;
  cell4 = newRow.insertCell(4);
  cell4.innerHTML = `<a onClick="onEdit(this)">Edit</a>
                       <a onClick="onDelete(this)">Delete</a>`;
}

function resetForm() {
  document.getElementById("id").value = "";
  document.getElementById("catName").value = "";
  document.getElementById("CatBreed").value = "";
  document.getElementById("catAge").value = "";
  selectedRow = null;
}

function onEdit(td) {
  selectedRow = td.parentElement.parentElement;
  document.getElementById("id").value = selectedRow.cells[0].innerHTML;
  document.getElementById("catName").value = selectedRow.cells[1].innerHTML;
  document.getElementById("CatBreed").value = selectedRow.cells[2].innerHTML;
  document.getElementById("catAge").value = selectedRow.cells[3].innerHTML;
}

function updateRecord(formData) {
  selectedRow.cells[0].innerHTML = formData.id;
  selectedRow.cells[1].innerHTML = formData.catName;
  selectedRow.cells[2].innerHTML = formData.CatBreed;
  selectedRow.cells[3].innerHTML = formData.catAge;
}

function onDelete(td) {
    if (confirm('Are you sure to delete this record ?')) {
        row = td.parentElement.parentElement;
        document.getElementById("catList").deleteRow(row.rowIndex);
        resetForm();
    }
}
