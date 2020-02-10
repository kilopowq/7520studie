$(document).ready(function() {
    if (document.getElementById("notApproved").value != null) {
        $('#myModalNotApproved').modal('show');
    }
});

$(document).ready(function() {
    $("#buttonLoadCart").click(productsView);
});

function decrease(id) {
    var $input = $(this).parent().find('input');
    var count = parseInt($input.val()) - 1;
    count = count < 1 ? 1 : count;
    $input.val(count);
    var val = document.getElementById('input-amount').value ;
    $input.change();
    val--;
    val = val < 1 ? 1 : val;
    changeCount(id, val);
}

function increase(id) {
    var $input = $(this).parent().find('input');
    $input.val(parseInt($input.val()) + 1);
    var val = document.getElementById('input-amount').value ;
    $input.change();
    val++;
    changeCount(id, val);
}

function inputChange(id) {
    var count = document.getElementById('input-amount').value;
    count = count < 1 ? 1 : count;
    changeCount(id, count);
}

function changeCount(id, value){
    $.when($.ajax(changeProductAmount(id, value)))
        .then(function() {
            productsView();
            cartProductSize();
        });
}

function changeProductAmount(id, value){
    $.post("/cart/changeProductAmount", {productId : id, value : value});
}

function productsView(){
    $("#products_table").load('/products_view #products_table');
}

function cartProductSize(){
    $.ajax({
        type : "GET",
        url : "/cart/cartProductCount",
        success: function(data){
            $("#buttonLoadCart").attr('data-count', data);
        }
    })
}

function removeCartProductFromCart(id) {
    $("#removeProductConfirmModal").modal('show');
    $("#modelButtonOk").on("click", function(){
        $.when($.ajax(removeProductFromCartPost(id)))
            .then(function() {
                productsView();
                cartProductSize();
            })
    });
}

function removeProductFromCartPost(id){
    $.post("/cart/removeCartProduct", {productId : id});
}

function showHint(str){
    $.post("/cart/add", {productId : str}).then(cartProductSize);
    $('#myModalAddedToYourShoppingCart').modal('show');

}
