$(document).ready(function() {
    if (document.getElementById("notApproved").value != null) {
        $('#myModalNotApproved').modal('show');
    }
});
$(document).ready(function() {
    if (document.getElementById("paramError").value != null) {
        $('#myModal').modal('show');
    }
});
$(document).ready(function() {
    if (document.getElementById("paramLogin").value != null) {
        $('#myModalApproved').modal('show');
    }
});
$(document).ready(function() {
    if (document.getElementById("notAuthorized").value != null) {
        $('#myModal').modal('show');
    }
});
$(document).ready(function() {
    if (document.getElementById("approvalLinkSended").value != null) {
        $('#myModalApprovalSentLink').modal('show');
    }
});
