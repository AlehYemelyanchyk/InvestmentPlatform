let checkbox = document.getElementById("customSwitch1");
checkbox.addEventListener("change", function () {
    this.value = this.checked ? 1 : 0;
    this.form.submit();
});
let checkbox2 = document.getElementById("customSwitch2");
checkbox2.addEventListener("change", function () {
    this.value = this.checked ? 1 : 0;
    this.form.submit();
});