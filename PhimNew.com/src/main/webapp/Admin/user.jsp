<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>




            <style>
                @keyframes rotate {
                    0% {
                        transform: rotate(0deg);
                    }

                    100% {
                        transform: rotate(360deg);
                    }
                }

                .rotate-icon {
                    animation: rotate 1s infinite linear;
                }
            </style>


            <!-- Modal -->
            <div class="modal fade" id="editUserModal" tabindex="-1" role="dialog" aria-labelledby="editUserModalLabel"
                aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="editUserModalLabel">Edit User</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <!-- Form fields to edit user details -->
                            <form>
                                <div class="form-group w-100">
                                    <label for="editUsername">User name</label>
                                    <input type="text" class="form-control" id="editUsername" ng-model="editedUser.id"
                                        disabled>
                                </div>
                                <div class="row">

                                    <div class="col-6">

                                        <div class="form-group">
                                            <label for="editPassword">Password</label>
                                            <input type="password" class="form-control" id="editPassword"
                                                ng-model="editedUser.password">
                                        </div>

                                        <div class="form-group">
                                            <label for="editPassword">Email</label>
                                            <input type="text" class="form-control" id="editEmail"
                                                ng-model="editedUser.email">
                                        </div>
                                        <div class="form-group">
                                            <span class="me-2">Gender: </span>
                                            <div class="d-flex">
                                                <div class="form-check" style="margin-right: 10px;">
                                                    <input ng-model="editedUser.gender" class="form-check-input" type="radio" name="gender" id="genderMale" value="true" ng-checked="editedUser.gender === true">

                                                    <label class="form-check-label" for="genderMale">
                                                        Nam
                                                    </label>
                                                </div>
                                                <div class="form-check">
                                                    <input ng-model="editedUser.gender" class="form-check-input" type="radio" name="gender" id="genderFemale" value="false" ng-checked="editedUser.gender === false">

                                                    <label class="form-check-label" for="genderFemale">
                                                        Nữ
                                                    </label>
                                                </div>
                                            </div>
                                        </div>

                                    </div>

                                    <div class="col-6">


                                        <div class="form-group">
                                            <label for="editPassword">FullName</label>
                                            <input type="text" class="form-control" id="editFullName"
                                                ng-model="editedUser.fullName">
                                        </div>
                                        <div class="form-group">
                                            <label for="editPassword">BirthDay</label>
                                            <input type="date" class="form-control" id="editBirthDay"
                                                ng-model="editedUser.birthday">
                                        </div>

                                        <div class="form-group">
                                            <span class="me-2">Role: </span><br>
                                            <div class="d-flex">
                                                <div class="form-check" style="margin-right: 10px;">
                                                    <input ng-model="editedUser.admin" class="form-check-input" type="radio" name="role" id="roleAdmin" value="true" ng-checked="editedUser.admin === true">
 
                                                    <label class="form-check-label" for="roleAdmin">
                                                        Admin
                                                    </label>
                                                </div>
                                                <div class="form-check">
                                                    <input ng-model="editedUser.admin" class="form-check-input" type="radio" name="role" id="roleUser" value="false" ng-checked="editedUser.admin === false">

                                                    <label class="form-check-label" for="roleUser">
                                                        User
                                                    </label>
                                                </div>
                                            </div>
                                        </div>

                                        <!-- Add other input fields here -->
                                    </div>
                                </div>



                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                            <button type="button" class="btn btn-primary" ng-click="saveChanges()">Save changes</button>
                            <button type="button" class="btn btn-danger" ng-click="deleteUser()">Delete</button>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Page Heading -->
            <h1 class="h3 mb-2 text-gray-800">User Management</h1>
            <p class="mb-4">Toàn bộ user đang tồn tại trong database PhimNew.com</p>

            <!-- DataTales Example -->
            <div class="card shadow mb-4">
                <div class="card-header py-3">
                    <h6 class="m-0 font-weight-bold text-primary">Users <span id="rotate-button" ng-click="getAll()"
                            class=" btn btn-info btn-circle btn-sm">
                            <i class="fas fa-sync"></i>
                        </span></h6>
                </div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                            <thead>
                                <tr class="text-center">
                                    <th>#</th>
                                    <th>User name</th>
                                    <th>Password</th>
                                    <th>Email</th>
                                    <th>Gender</th>
                                    <th>FullName</th>
                                    <th>BirthDay</th>
                                    <th>Role</th>
                                    <th>Edit</th>
                                </tr>
                            </thead>
                            <tfoot>
                                <tr class="text-center">
                                    <th>#</th>
                                    <th>User name</th>
                                    <th>Password</th>
                                    <th>Email</th>
                                    <th>Gender</th>
                                    <th>FullName</th>
                                    <th>BirthDay</th>
                                    <th>Role</th>
                                    <th>Edit</th>
                                </tr>
                            </tfoot>
                            <tbody>
                                <tr ng-repeat="u in users">
                                    <td class="text-center">{{$index+1}}</td>
                                    <td class="text-center">{{u.id}}</td>
                                    <td class="text-center">*****</td>
                                    <td class="text-center">{{u.email}}</td>
                                    <td class="text-center">{{u.gender ? 'Nam' : 'Nữ'}}</td>
                                    <td class="text-center">{{u.fullName}}</td>
                                    <td class="text-center">{{u.birthday | dateFormat}}</td>
                                    <td class="text-center">{{u.admin ? 'Admin' : 'User'}}</td>
                                    <td class="text-center">
                                        <!-- Nút chỉnh sửa -->
                                        <button ng-click="openEditModal(u)" class="btn btn-warning btn-circle btn-sm">
                                            <i class="fas fa-edit"></i>
                                        </button>

                                        <!-- Nút xóa -->
                                        <button class="btn btn-danger btn-circle btn-sm">
                                            <i class="fas fa-trash"></i>
                                        </button>
                                    </td>
                                </tr>

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>





            <!-- Page level plugins -->
            <script src="Admin/vendor/datatables/jquery.dataTables.min.js"></script>
            <script src="Admin/vendor/datatables/dataTables.bootstrap4.min.js"></script>

            <!-- Page level custom scripts -->
            <script src="Admin/js/demo/datatables-demo.js"></script>