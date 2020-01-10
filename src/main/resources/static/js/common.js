
// 保存快递信息
function saveExpressInfo(state) {
    //获取参数信息
    var companyCode =$("#companyOption option:selected").val();
    var phone = $('#fPhone').val();
    var name = $('#fName').val();
    if (phone == ''){
        swal("手机号码不能为空！")
        return;
    }
    if (name == ''){
        swal("收件人姓名不能为空！")
        return;
    }
    $.ajax({
        url: location.protocol + "/express/saveExpress",
        type: 'POST',
        // type: "GET",
        data: { "expressNum":num,
            "companyCode":companyCode,
            "phone":phone,
            "name":name,
            "state":state
        },
        success: function (data) {
            if (data.status == 200) {
                swal({
                    title: data.data,
                    confirmButtonText: "确定"
                }, function (isConfirm) {
                    location.reload()
                    return;
                })
                return;
            }else if (data.status == 501){
                $('#eNumb').val(numb);
                $('#addExpress').modal();
            }else {
                swal(data.msg);
            }
        },
        error: function (data) {
            swal('添加快递信息异常，请联系祥哥~！');
        }
    });
}



function laodCompany() {
    $.ajax({
        url: location.protocol + "/express/loadCompanyName",
        type: 'GET',
        // data: {"state":1},
        success: function (data) {
            if (data.status == 200){
                var company = data.data;
                if (company.length > 0){
                    var content = '<option value="0">请选择</option>';
                    for (i = 0 ; i < company.length ; i ++){
                        var comp = company[i];
                        content +=  '<option value=' + comp.id +'>' + comp.eCompanyName + '</option>'
                    }
                    $('#companyOption').append(content);
                }
                // swal(data.data);
                return;
            }
            swal(data.msg);

        },
        error: function (data) {
            swal('添加快递信息异常，请联系祥哥~！');
        }
    });
}

function loadUserName() {
    var mobile = $('#fPhone').val();
    $.ajax({
        url: location.protocol + "/express/loadUser",
        type: 'GET',
        data: {"mobile":mobile},
        success: function (data) {
            if (data.status == 200){
                var user = data.data;
                // alert(user.name)
                $('#fName').val(user.name);
                return;
            }
            // swal(data.msg);
        },
        error: function (data) {
            swal('添加快递信息异常，请联系祥哥~！');
        }
    });
}

function loadUserName() {
    var mobile = $('#fPhone').val();
    $.ajax({
        url: location.protocol + "/express/loadUser",
        type: 'GET',
        data: {"mobile":mobile},
        success: function (data) {
            if (data.status == 200){
                var user = data.data;
                // alert(user.name)
                $('#fName').val(user.name);
                return;
            }
            // swal(data.msg);
        },
        error: function (data) {
            swal('添加快递信息异常，请联系祥哥~！');
        }
    });
}

