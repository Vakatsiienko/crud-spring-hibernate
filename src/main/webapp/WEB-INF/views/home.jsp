<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Basic CRUD Application - jQuery EasyUI CRUD Demo</title>
    <link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/color.css">
    <link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/demo/demo.css">
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.6.min.js"></script>
    <script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
</head>
<body>
<h2>Basic CRUD Application</h2>

<table id="dg" title="Users List" class="easyui-datagrid" style="width:700px;height:250px"
       url="/users"
       method="GET"
       toolbar="#toolbar" pagination="true"
       rownumbers="true" fitColumns="true" singleSelect="true">
    <thead>
    <tr>
        <th field="id" width="50">ID</th>
        <th field="name" width="50">Name</th>
        <th field="age" width="50">Age</th>
        <th field="admin" checkbox="true" width="50">Permission</th>
        <th field="createdDate" width="50">Created Date</th>
    </tr>
    </thead>
</table>
<div id="toolbar">
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">New User</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">Edit User</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyUser()">Remove User</a>
</div>

<div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px"
     closed="true" buttons="#dlg-buttons">
    <div class="ftitle">User Information</div>
    <form id="fm" novalidate>
        <div class="fitem">
            <label>Name:</label>
            <input name="name" class="easyui-textbox" required="true">
        </div>
        <div class="fitem">
            <label>Age:</label>
            <input name="age" class="easyui-textbox" required="true">
        </div>
        <div class="fitem">
            <label>Permission:</label>
            <input type="checkbox" name="admin" class="easyui-textbox">
        </div>
    </form>
</div>
<div id="dlg-buttons">
    <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveUser()" style="width:90px">Save</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">Cancel</a>
</div>
<script type="text/javascript">
    var url, method;
    function newUser() {
        $('#dlg').dialog('open').dialog('setTitle', 'New User');
        $('#fm').form('clear');
        url = '/users';
        method = "POST";
    }
    function editUser() {
        console.log("Edit user called")
        var row = $('#dg').datagrid('getSelected');
        if (row) {
            $('#dlg').dialog('open').dialog('setTitle', 'Edit User');
            $('#fm').form('load', row);
            url = '/users/' + row.id;
            method = "PUT";
        }
    }
    function saveUser() {
        function serializeUser(formData) {
            formData.admin = formData.admin === 'on';
            formData.age = parseInt(formData.age);
            return JSON.stringify(formData);
        }

        $.ajax({
            url: url,
            type: method,
            headers: {"Content-type": "application/json"},
            data: serializeUser(getFormData($('#fm'))),
            success: function (result) {
                if (!result.success) {
                    $.messager.show({
                        title: 'Error',
                        msg: "An Error occurred"
                    });
                } else {
                    $('#dlg').dialog('close');		// close the dialog
                    $('#dg').datagrid('reload');	// reload the user data
                }
            }
        });
    }
    function getFormData($form){
        var unindexed_array = $form.serializeArray();
        var indexed_array = {};
        $.map(unindexed_array, function(n, i){
            indexed_array[n['name']] = n['value'];
        });

        return indexed_array;
    }
    function destroyUser() {
        var row = $('#dg').datagrid('getSelected');
        if (row) {
            $.messager.confirm('Confirm', 'Are you sure you want to destroy this user?', function (r) {
                if (r) {
                    $.ajax({
                        url: 'users/' + row.id,
                        type: "DELETE",
                        success: function (result) {
                            if (result.success) {
                                $('#dg').datagrid('reload');	// reload the user data
                            } else {
                                $.messager.show({	// show error message
                                    title: 'Error',
                                    msg: "Could not delete user"
                                });
                            }
                        }
                    });
                }
            });
        }
    }
//    $('#dg').datagrid({
//        loader: function (param, success, error) {
//            jQuery.ajax({
//                url: 'users?page=' + param.page + "&rows=" + param.rows,
//                type: 'GET',
//                success: function (data) {
//                    var pager = $("#dg").datagrid("getPager");
//
//                    success(data.rows);
//                }
//            });
//        }
//    })
</script>
<style type="text/css">
    #fm {
        margin: 0;
        padding: 10px 30px;
    }

    .ftitle {
        font-size: 14px;
        font-weight: bold;
        padding: 5px 0;
        margin-bottom: 10px;
        border-bottom: 1px solid #ccc;
    }

    .fitem {
        margin-bottom: 5px;
    }

    .fitem label {
        display: inline-block;
        width: 80px;
    }

    .fitem input {
        width: 160px;
    }
</style>
</body>
</html>