/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//for menu toggle for site nav
$("#menu-toggle").click(function (e) {
    e.preventDefault();
    $("#wrapper").toggleClass("toggled");
});
//for ratings
$('[data-rating] .star').on('click', function () {
    var selectedCssClass = 'selected';
    var $this = $(this);
    $this.siblings('.' + selectedCssClass).removeClass(selectedCssClass);
    $this
            .addClass(selectedCssClass)
            .parent().addClass('is-voted');
});

