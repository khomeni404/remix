/**
 * Created by Khomeni on 16-May-17.
 */

$('.se-num').on('keypress', function (e) {
    return e.charCode >= 48 && e.charCode <= 57
});

$('.se-amt').on('keypress', function (event) { // 46 = dot
    return (event.charCode >= 48 && event.charCode <= 57) || event.charCode == 46;
});

$('.btn-back').on('click', function () {
    window.history.back();
});
