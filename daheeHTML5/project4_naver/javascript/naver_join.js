        $(document).ready(function() {

            var joinCheck = {
                userId: 0,
                userPw: 0,
                userPwc: 0,
                userName: 0,
                brith_year: 0,
                brith_month: 0,
                brith_day: 0,
                userPhone: 0,
                userPhoneNum: 0
            };


            /*joinCheck.userId = 1;
            alert($.param(joinCheck))*/

            //월 옵션만들기
            for (var i = 1; i <= 12; i++) {
                $('#brith_month').append($('<option />').val(i).html(i));
            }

            //전화번호 인증번호 입력하는칸 막기
            $('#userPhoneNum').attr('disabled', true);

            $('.input').focusin(function() {
                $(this).parent().css('border', '1px solid #08a600');
            });

            $('.input').focusout(function() {
                $(this).parent().css('border', '1px solid #dadada');
            });

            //아이디 유효성 검사
            $('#userId').focusout(function() {
                if ($(this).val().length < 1) {
                    $(this).parent().next().html('필수정보입니다.');
                    joinCheck.userId = 0;
                } else {
                    var id = $('#userId').val();

                    //영문자 대소문자, 숫자와 - _ 만가능 5~20자리까지
                    var idCheck = /^[a-zA-Z0-9_-]{5,20}$/;

                    if (idCheck.test(id)) {
                        $(this).parent().next().html('멋진 아이디네요!').css('color', '#08A600');
                        joinCheck.userId = 1;
                    } else {
                        $(this).parent().next().html('5~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.');
                        joinCheck.userId = 0;
                    }
                }
            });

            //비밀번호 유효성 검사
            $('#userPw').focusout(function() {

                if ($(this).val().length < 1) {
                    $(this).parent().next().html('필수정보입니다.');
                    $('#userPw+label span').css('background-image', 'url(https://static.nid.naver.com/images/ui/join/m_icon_pass.png)');
                    joinCheck.userPw = 0;
                } else {
                    var pw = $('#userPw').val();
                    //영문대소문자로 이루어지고 최소 하나의 숫자와 특수문자가와야함
                    var pwCheck = /^(?=.*[a-zA-Z])((?=.*\d)|(?=.*\W)).{8,16}$/

                    if (pwCheck.test(pw)) {
                        $(this).parent().next().html('');
                        $('#userPw+label span').css('background-image', 'url(https://static.nid.naver.com/images/ui/join/m_icon_safe.png)');
                        joinCheck.userPw = 1;
                    } else {
                        $(this).parent().next().html('8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.');
                        $('#userPw+label span').css('background-image', 'url(https://static.nid.naver.com/images/ui/join/m_icon_not_use.png)');
                        joinCheck.userPw = 0;
                    }
                }
            });


            //비밀번호 재확인 유효성 검사
            $('#userPwc').focusout(function() {

                if ($(this).val().length < 1) {
                    $(this).parent().next().html('필수정보입니다.');
                    $('#userPwc+label span').css('background-image', 'url(https://static.nid.naver.com/images/ui/join/pc_icon_check_disable_180417.png)');
                    joinCheck.userPwc = 0;
                } else {
                    var pw = $('#userPw').val();
                    var pwC = $('#userPwc').val();

                    if (pw == pwC) {
                        $(this).parent().next().html('');
                        $('#userPwc+label span').css('background-image', 'url(https://static.nid.naver.com/images/ui/join/pc_icon_check_enable_180417.png)');
                        joinCheck.userPwc = 1;
                    } else {
                        $(this).parent().next().html('비밀번호가 일치하지 않습니다.');
                        $('#userPwc+label span').css('background-image', 'url(https://static.nid.naver.com/images/ui/join/pc_icon_check_disable_180417.png)');
                        joinCheck.userPwc = 0;
                    }
                }
            });

            //이름 유효성 검사
            $('#userName').focusout(function() {

                if ($(this).val().length < 1) {
                    $(this).parent().next().html('필수정보입니다.');
                    joinCheck.userName = 0;
                } else {
                    $(this).parent().next().html('');
                    var name = $('#userName').val();

                    //\S : 공백이아닌문자가 와야하고
                    //가-힣a-zA-Z : 한글과 영어소문자대문자만
                    //* : 글자수제한X
                    var nameCheck = /^\S[가-힣a-zA-Z]*$/;

                    if (nameCheck.test(name)) {
                        $(this).parent().next().html('');
                        joinCheck.userName = 1;
                    } else {
                        $(this).parent().next().html('한글과 영문 대 소문자를 사용하세요. (특수기호, 공백 사용 불가)');
                        joinCheck.userName = 0;
                    }
                }
            });

            //생년월일 유효성 검사
            $('#brith_div input, #brith_month').focusout(function() {
                var year = $('#brith_year').val();
                var month = $('#brith_month').val();
                var day = $('#brith_day').val();

                var date = new Date();

                if (year.length < 1 || year.length < 4) {
                    $('#brith_div h5').html('태어난 년도 4자리를 정확하게 입력하세요.');
                    joinCheck.brith_year = 0;
                    joinCheck.brith_month = 0;
                    joinCheck.brith_day = 0;
                } else if (day.length < 1 || day.length < 2) {
                    $('#brith_div h5').html('태어난 일(날짜) 2자리를 정확하게 입력하세요.');
                    joinCheck.brith_year = 1;
                    joinCheck.brith_month = 0;
                    joinCheck.brith_day = 0;
                } else if (day > 31) {
                    $('#brith_div h5').html('생년월일을 다시 확인해주세요.');
                    joinCheck.brith_year = 1;
                    joinCheck.brith_month = 0;
                    joinCheck.brith_day = 0;
                } else {
                    $('#brith_div h5').html('');
                    //공백불가에 숫자만 글자수제한없이 검사 (tag 속성에 미리 글자수제한함)
                    var brithCheck = /^[0-9]\S*$/;

                    if (brithCheck.test(year) && brithCheck.test(month) && brithCheck.test(day)) {
                        $('#brith_div h5').html('');
                        joinCheck.brith_year = 1;
                        joinCheck.brith_month = 1;
                        joinCheck.brith_day = 1;

                        //getFullYear : Date() 에서 현재 년도를 가져옴
                        if (date.getFullYear() < year) {
                            $('#brith_div h5').html('미래에서 오셨군요. ^^');
                        } else if (year < 1920) {
                            $('#brith_div h5').html('정말이세요?');
                        }
                    } else {
                        $('#brith_div h5').html('생년월일을 다시 확인해주세요.');
                        joinCheck.brith_year = 0;
                        joinCheck.brith_month = 0;
                        joinCheck.brith_day = 0;
                    }
                }
            });

            //휴대전화 유효성검사
            $('#userPhone').focusout(function() {
                if ($(this).val().length < 1) {
                    $('#phone_div h5').html('필수정보입니다.');
                    joinCheck.userPhone = 0;
                } else {
                    $('#phone_div h5').html('');
                    joinCheck.userPhone = 1;
                }
            });

            //인증번호 받기 버튼 클릭시 전화번호 유효성검사
            $('#phoneBtn').click(function() {
                var phone = $('#userPhone').val();
                //01로 시작하고 그 뒤에는 0,1,6,7,8,9가 올 수 있고
                //-(하이픈)은 써도되고 안써도되지만 정확한자리에 들어가야한다
                var phoneCheck = /^01([0|1|6|7|8|9]?)-?([0-9]{3,4})-?([0-9]{4})$/;

                if (phoneCheck.test(phone)) {
                    $('#phone_div h5').html('인증번호를 발송했습니다.(유효시간 30분)<br>인증번호가 오지 않으면 입력하신 정보가 정확한지 확인하여 주세요.<br>이미 가입된 번호이거나, 가상전화번호는 인증번호를 받을 수 없습니다.').css('color', '#08A600');

                    //인증번호 입력칸 활성화
                    $('#userPhoneNum').attr('disabled', false);
                    $('#phone_div div span:last-child, #phone_div div span:last-child input').css('background-color', 'white');

                } else {
                    $('#phone_div h5').html('형식에 맞지 않는 번호입니다.');
                }
            })

            //인증번호 입력칸 유효성검사
            $('#userPhoneNum').focusout(function() {

                if ($(this).val().length < 1) {
                    $('#phone_div h4').html('인증이 필요합니다.');
                    joinCheck.userPhoneNum = 0;
                } else {
                    $('#phone_div h4').html('');
                    joinCheck.userPhoneNum = 1;
                }
            });

            //가입하기 버튼 클릭시 유효성 검사
            $('#form').submit(function() {
                $.each(joinCheck, function(index, item) {
                    if (item != 1) {
                        $('#' + index).closest('div').find('h5').html('필수 정보입니다.');
                    }
                });
                return false;
            });
        });