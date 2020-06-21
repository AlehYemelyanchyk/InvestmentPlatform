// const login = document.getElementById("login");
// const password = document.getElementById("password");
// const form = document.getElementById("form");
// const errorElement = document.getElementById('error');
//
// form.addEventListener('submit', (e) =>{
//     let messages = [];
//     if (login.value === '' || login.value == null){
//         messages.push('A login must contain at least 1 character')
//     }
//
//     if (messages.length > 0){
//         e.preventDefault();
//         errorElement.innerText = messages.join(', ');
//     }
// });

(function () {
    window.addEventListener('load', function () {
        // Fetch all the forms we want to apply custom Bootstrap validation styles to
        var forms = document.getElementsByClassName('needs-validation');
        // Loop over them and prevent submission
        var validation = Array.prototype.filter.call(forms, function (form) {
            form.addEventListener('submit', function (event) {
                if (form.checkValidity() === false) {
                    event.preventDefault();
                    event.stopPropagation();
                    var ele = form.getElementsByTagName("input")
                    for (var i = 0; i < ele.length; i++) {
                        var msg = "", reason = ele[i].validity;
                        if (reason.valueMissing) {
                            msg = ele[i].getAttribute("data-value-missing");
                        } else if (reason.tooShort) {
                            msg = ele[i].getAttribute("data-pattern-length-mismatch");
                        } else if (reason.patternMismatch) {
                            msg = ele[i].getAttribute("data-pattern-mismatch");
                        } else {
                            msg = ele[i].getAttribute("data-value-missing");
                        }
                        console.log(ele[i]);
                        console.log(reason);
                        ele[i].nextElementSibling.nextElementSibling.innerText = msg;
                    }
                }
                form.classList.add('was-validated');
            }, false);
        });
    }, false);
})();