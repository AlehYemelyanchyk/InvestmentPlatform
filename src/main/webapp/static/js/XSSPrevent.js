function XSSPrevent() {
    let nameInput;
    let elementName;
    let form = document.forms[0];
    let elements = document.forms.item(0).elements;

    for (let index = 0; index < elements.length; ++index) {
        if (elements.item(index).getAttribute("name") != null) {
            elementName = elements.item(index).getAttribute("name");
            nameInput = form.elements[elementName].value;
        }

        if (nameInput != null) {
            let fixedUserComment = nameInput;
            while (fixedUserComment.includes("<") || fixedUserComment.includes(">")) {
                fixedUserComment = fixedUserComment.replace("<", "&lt").replace(">", "&gt");
                form.elements[elementName].value = fixedUserComment;
            }
        }
    }
}