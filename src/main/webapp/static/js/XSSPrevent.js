function XSSPrevent() {
    var userComment = document.getElementById("input").value;
    if (userComment.includes("<") || userComment.includes(">")) {
        var fixedUserComment = userComment.replace("<", "&lt").replace(">", "&gt");
        document.getElementById("input").value = fixedUserComment;
    }
}