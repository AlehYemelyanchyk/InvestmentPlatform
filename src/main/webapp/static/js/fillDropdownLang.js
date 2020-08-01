let select = document.getElementById("langs");
let langCookie = document.cookie;
let lang = langCookie.split('=')[1];

let options = [
    {
        "option": "en",
        "value": "en"
    },
    {
        "option": "ru",
        "value": "ru"
    },
    {
        "option": "by",
        "value": "by"
    }
];
for(let i = 0; i < options.length; i++) {
    if(options[i].value === lang) {
        let opt = options[i].option;
        let value = options[i].value;
        let el = document.createElement("option");
        el.textContent = opt;
        el.value = value;
        select.appendChild(el);
    }
}
for(let i = 0; i < options.length; i++) {
    if(options[i].value != lang) {
        let opt = options[i].option;
        let value = options[i].value;
        let el = document.createElement("option");
        el.textContent = opt;
        el.value = value;
        select.appendChild(el);
    }
}