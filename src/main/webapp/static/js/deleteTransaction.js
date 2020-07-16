function deleteTransaction(id) {
    event.preventDefault();
    swal({
        title: "Are you sure?",
        text: "Once deleted this transaction, you will not be able to restore it.",
        icon: "warning",
        buttons: true,
        dangerMode: true,
    })
        .then((willDelete) => {
            if (willDelete) {
                swal("Done! The transaction has been deleted!", {
                    icon: "success",
                }).then(() => {
                    document.getElementById("formRemove".concat(id)).submit();
                });
            } else {
                swal("The transaction will not be deleted!");
            }
        });
}