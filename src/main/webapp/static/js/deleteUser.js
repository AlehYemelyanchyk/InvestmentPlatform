function deleteUser(login) {
    event.preventDefault();
    swal({
        title: "Are you sure?",
        text: "Once deleted the user \"" + login + "\", you will not be able to restore it.",
        icon: "warning",
        buttons: true,
        dangerMode: true,
    })
        .then((willDelete) => {
            if (willDelete) {
                swal("Done! The user \"" + login + "\" has been deleted!", {
                    icon: "success",
                }).then(() => {
                    document.getElementById("formRemove".concat(login)).submit();
                });
            } else {
                swal("\"" + login + "\" will not be deleted!");
            }
        });
}