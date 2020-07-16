function deleteSecurity(name) {
    event.preventDefault();
    swal({
        title: "Are you sure?",
        text: "Once deleted \"" + name + "\", you will loose all its transactions.",
        icon: "warning",
        buttons: true,
        dangerMode: true,
    })
        .then((willDelete) => {
            if (willDelete) {
                swal("Done! \"" + name + "\" has been deleted!", {
                    icon: "success",
                }).then(() => {
                    document.getElementById("formRemove".concat(name)).submit();
                });
            } else {
                swal("\"" + name + "\" will not be deleted!");
            }
        });
}