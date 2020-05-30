function XSSPrevent() {
    var activeElement = document.activeElement.getAttributeNames();
    var userComment = document.getElementById("input").value;
    console.log(activeElement)
    console.log(userComment)
    if (userComment.includes("<") || userComment.includes(">")) {
        var fixedUserComment = userComment.replace("<", "&lt").replace(">", "&gt");
        document.getElementById("input").value = fixedUserComment;
    }
}