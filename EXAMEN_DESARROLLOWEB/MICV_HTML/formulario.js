document.addEventListener("DOMContentLoaded", () => {
    const fetchUsersButton = document.getElementById("fetchUsers");
    const userList = document.getElementById("user-list");

    fetchUsersButton.addEventListener("click", () => {
        fetch('http://localhost:1700/OW')
            .then(response => response.json())
            .then(data => {
                userList.innerHTML = "";
                data.forEach(user => {
                    const userItem = document.createElement('div');
                    userItem.classList.add('user-item');
                    userItem.innerHTML = `
                        <h3>${user.name}</h3>
                        <p>Nacionalidad: ${user.nationality}</p>
                    `;
                    userList.appendChild(userItem);
                });
            })
            .catch(error => console.error('Error fetching users:', error));
    });
});