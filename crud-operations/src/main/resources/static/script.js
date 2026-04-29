const API = "http://localhost:8080/students";

// ADD STUDENT
function addStudent() {
    const student = {
        name: document.getElementById("name").value,
        email: document.getElementById("email").value,
        course: document.getElementById("course").value
    };

    fetch(API, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(student)
    })
    .then(() => {
        loadStudents();
        document.getElementById("name").value = "";
        document.getElementById("email").value = "";
        document.getElementById("course").value = "";
    })
    .catch(err => console.log(err));
}

// LOAD STUDENTS
function loadStudents() {
    fetch(API)
        .then(res => res.json())
        .then(data => {
            const list = document.getElementById("studentList");
            list.innerHTML = "";

            data.forEach(s => {
                const div = document.createElement("div");
                div.className = "card";

                div.innerHTML = `
                    <span><b>${s.name}</b> | ${s.email} | ${s.course}</span>
                    <button class="delete-btn" onclick="deleteStudent(${s.id})">Delete</button>
                `;

                list.appendChild(div);
            });
        })
        .catch(err => console.log(err));
}

// DELETE
function deleteStudent(id) {
    fetch(API + "/" + id, { method: "DELETE" })
        .then(() => loadStudents())
        .catch(err => console.log(err));
}

// LOAD ON START
window.onload = function () {
    loadStudents();
};