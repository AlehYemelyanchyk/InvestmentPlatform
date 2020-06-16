const userRole = document.getElementById("userRole").value;
const elements = document.getElementsByClassName("guest-hidden");
Array.from(elements).forEach((element) => {
    if (userRole !== "1" && userRole !== "2") {
        element.setAttribute("hidden", "true");
    } else if (userRole === 2) {
        let element = document.getElementById("user-hidden");
        element.setAttribute("hidden", "true");
    }
});
