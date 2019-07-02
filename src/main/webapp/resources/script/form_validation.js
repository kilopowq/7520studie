$(document).ready(function(){
    $("#nameForm").keydown(function(){
        $("#nameForm").removeClass("is-invalid");
        $("#nameError").hide("errormsg");

    });
});
$(document).ready(function(){
    $("#sernameForm").keydown(function(){
        $("#sernameForm").removeClass("is-invalid");
        $("#sernameError").hide("errormsg");

    });
});
$(document).ready(function(){
    $("#middlenameForm").keydown(function(){
        $("#middlenameForm").removeClass("is-invalid");
        $("#middlenameError").hide("errormsg");

    });
});
$(document).ready(function(){
    $("#phoneForm").keydown(function(){
        $("#phoneForm").removeClass("is-invalid");
        $("#phoneError").hide("errormsg");

    });
});
$(document).ready(function(){
    $("#emailForm").keydown(function(){
        $("#emailForm").removeClass("is-invalid");
        $("#emailError").hide("errormsg");

    });
});
$(document).ready(function(){
    $("#addressCityForm").keydown(function(){
        $("#addressCityForm").removeClass("is-invalid");
        $("#addressCityError").hide("errormsg");

    });
});
$(document).ready(function(){
    $("#addressStreetForm").keydown(function(){
        $("#addressStreetForm").removeClass("is-invalid");
        $("#addressStreetError").hide("errormsg");

    });
});
$(document).ready(function(){
    $("#addressHouseForm").keydown(function(){
        $("#addressHouseForm").removeClass("is-invalid");
        $("#addressHouseError").hide("errormsg");

    });
});
$(document).ready(function(){
    $("#loginForm").keydown(function(){
        $("#loginForm").removeClass("is-invalid");
        $("#loginError").hide("errormsg");

    });
});
$(document).ready(function(){
    $("#passwordForm").keydown(function(){
        $("#passwordForm").removeClass("is-invalid");
        $("#passwordError").hide("errormsg");

    });
});
$(document).ready(function(){
    $("#passwordForm, #confirmPasswordForm").keyup(function(){
        if ($('#passwordForm').val() == $('#confirmPasswordForm').val()) {
            $('#confirmPasswordForm').removeClass("is-invalid");
            $('#submitForm').attr("disabled",false);
        } else {
            $('#confirmPasswordForm').addClass("is-invalid");
            $('#submitForm').attr("disabled", true);
        }
    });
});