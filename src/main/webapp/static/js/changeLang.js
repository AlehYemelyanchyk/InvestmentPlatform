function changeLang() {
    let selectBox = document.getElementById("langs");
    let selectedValue = selectBox.options[selectBox.selectedIndex].value;
    if (selectedValue === "by") {
        document.cookie = "lang=by";
    } else if (selectedValue === "ru") {
        document.cookie = "lang=ru";
    } else {
        document.cookie = "lang=en";
    }
    document.location.reload();
}