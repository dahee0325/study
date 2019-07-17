$(document).ready(function () {

    //allCheck 의 상태가변경이 되면
    $('#all_check').change(function () {

        //this의 checked 속성을 가져옴
        var chk = $(this).prop('checked');
        $('#all_check+label').css('background-image', 'url(https://static.nid.naver.com/images/ui/myinfo/pc_check_on_l_24.png)');

        if (chk) {
            $('#terms_wrap input').prop('checked', true);
            $('#check label').css('background-image', 'url(https://static.nid.naver.com/images/ui/myinfo/pc_chcek_on_s_20.png)');
        } else {
            $('#all_check+label').css('background-image', 'url(https://static.nid.naver.com/images/ui/myinfo/pc_check_off_24.png)');
            $('#terms_wrap input').prop('checked', false);
            $('#check label').css('background-image', 'url(https://static.nid.naver.com/images/ui/myinfo/pc_chcek_off_s_20.png)');
        }

    });


    $('#check input').change(function () {

        var check = $(this).prop('checked');

        if (check) {
            $(this).next().css('background-image', 'url(https://static.nid.naver.com/images/ui/myinfo/pc_chcek_on_s_20.png)');
        } else {
            $(this).next().css('background-image', 'url(https://static.nid.naver.com/images/ui/myinfo/pc_chcek_off_s_20.png)');
            $('#all_check').prop('checked', false);
            $('#all_check+label').css('background-image', 'url(https://static.nid.naver.com/images/ui/myinfo/pc_check_off_24.png)');
        }

        if ($('#check1').prop('checked') && $('#check2').prop('checked') && $('#check3').prop('checked') && $('#check4').prop('checked')) {
            $('#all input').prop('checked', true);
            $('#all_check+label').css('background-image', 'url(https://static.nid.naver.com/images/ui/myinfo/pc_check_on_l_24.png)');
        }

    });


    $('#btn_true').click(function () {

        if ($('#check1').prop('checked') && $('#check2').prop('checked')) {
            location.href = 'naver_join.html';

        } else {
            $('#btn_false_p').css('display', 'block');
        }

    });

});