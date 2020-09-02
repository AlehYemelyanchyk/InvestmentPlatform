function read() {
    let password = document.getElementById('password');
    let inputPass = password.value;
    let passwordRepeat = document.getElementById('passwordRepeat');
    let pattern = passwordRepeat.attributes.getNamedItem('pattern');
    pattern.value = inputPass;
}