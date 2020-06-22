(function () {
    window.addEventListener('load', function () {
        // Fetch all the forms we want to apply custom Bootstrap validation styles to
        let forms = document.getElementsByClassName('needs-validation');
        // Loop over them and prevent submission
        let validation = Array.prototype.filter.call(forms, function (form) {
            form.addEventListener('submit', function (event) {
                if (form.checkValidity() === false) {
                    event.preventDefault();
                    event.stopPropagation();
                    let ele = form.getElementsByTagName("input")
                    for (let i = 0; i < ele.length; i++) {
                        let msg = "", reason = ele[i].validity;
                        if (reason.valueMissing) {
                            msg = ele[i].getAttribute("data-value-missing");
                        } else if (reason.tooShort) {
                            msg = ele[i].getAttribute("data-pattern-length-mismatch");
                        } else if (reason.patternMismatch) {
                            msg = ele[i].getAttribute("data-pattern-mismatch");
                        } else if (reason.rangeOverflow) {
                            msg = ele[i].getAttribute("data-range-overflow");
                        } else {
                            msg = ele[i].getAttribute("data-value-missing");
                        }
                        ele[i].nextElementSibling.nextElementSibling.innerText = msg;
                    }
                }
                form.classList.add('was-validated');
            }, false);
        });
    }, false);
})();