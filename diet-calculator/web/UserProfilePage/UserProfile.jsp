<!DOCTYPE html>
<html>
    <head>
        <meta charset='utf-8'>
        <meta http-equiv='X-UA-Compatible' content='IE=edge'>
        <title>User Profile</title>
        <meta name='viewport' content='width=device-width, initial-scale=1'>
        <link rel="stylesheet" href="UserProfile.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </head>

    <body>
        <jsp:include page="../index/UserHeader.jsp" />
        <div class="container" style="margin-top: 150px; margin-bottom: 100px">
            <div class="main-body">
                <div class="row gutters-sm">
                    <div class="col-md-4 mb-3">
                        <div class="card">
                            <div class="card-body">
                                <div class="d-flex flex-column align-items-center text-center">
                                    <img src="https://bootdey.com/img/Content/avatar/avatar7.png" alt="Admin" class="rounded-circle" width="150">
                                    <div class="mt-3">
                                        <h4>${object.username}</h4>
<!--                                        <p class="text-secondary mb-1">Full Stack Developer</p>
                                        <p class="text-muted font-size-sm">Ho Chi Minh, VietNam</p>
                                        <button class="btn btn-success">Follow</button>
                                        <button class="btn btn-outline-success">Message</button>-->
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                    <div class="col-md-8">
                        <div class="card mb-3">
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-sm-3">
                                        <h6 class="mb-0">Full Name</h6>
                                    </div>
                                    <div class="col-sm-9 text-secondary">
                                        ${object.username}
                                    </div>
                                </div>
                                <hr>
                                <div class="row">
                                    <div class="col-sm-3">
                                        <h6 class="mb-0">Date of Birth</h6>
                                    </div>
                                    <div class="col-sm-9 text-secondary">
                                        ${object.dob}
                                    </div>
                                </div>
                                <hr>
                                <div class="row">
                                    <div class="col-sm-3">
                                        <h6 class="mb-0">Email</h6>
                                    </div>
                                    <div class="col-sm-9 text-secondary">
                                        ${object.email}
                                    </div>
                                </div>
                                <hr>
                                <div class="row">
                                    <div class="col-sm-3">
                                        <h6 class="mb-0">Phone</h6>
                                    </div>
                                    <div class="col-sm-9 text-secondary">
                                        ${object.phone}
                                    </div>
                                </div>
                                <hr>
                                <div class="row">
                                    <div class="col-sm-3">
                                        <h6 class="mb-0"> Address </h6>
                                    </div>
                                    <div class="col-sm-9 text-secondary">
                                        ${object.address}
                                    </div>
                                </div>
                                <hr>
                                <div class="row">
                                    <div class="col-sm-3">
                                        <h6 class="mb-0"> Weight(kg) </h6>
                                    </div>
                                    <div class="col-sm-9 text-secondary">
                                        ${object.weight} 
                                    </div>
                                </div>
                                <hr>
                          
                                <div class="row">
                                    <div class="col-sm-3">
                                        <h6 class="mb-0"> Height(cm) </h6>
                                    </div>
                                    <div class="col-sm-9 text-secondary">
                                        ${object.height} 
                                    </div>
                                </div>
                                <hr>

            
                                <div class="row">
                                    <div class="col-sm-3">
                                        <h6 class="mb-0"> Gender </h6>
                                    </div>
                                    <div class="col-sm-9 text-secondary">
                                        ${object.gender} 
                                    </div>
                                </div>
                                <hr>
                                <div class="row">
                                    <div class="col-sm-3">
                                        <h6 class="mb-0"> Activity </h6>
                                    </div>
                                    <div class="col-sm-9 text-secondary">
                                        ${object.activity} 
                                    </div>
                                </div>
                                <hr>
                                <div class="row">
                                    <div class="col-sm-3">
                                        <h6 class="mb-0"> Preference </h6>
                                    </div>
                                    <div class="col-sm-9 text-secondary">
                                        ${object.preference} 
                                    </div>
                                </div>
                                <hr>
                                <div class="row">
                                    <div class="col-sm-3">
                                        <h6 class="mb-0"> Goal </h6>
                                    </div>
                                    <div class="col-sm-9 text-secondary">
                                        ${object.goal} 
                                    </div>
                                </div>
                                <hr>
                                <div class="row">
                                    <div class="col-sm-3">
                                        <h6 class="mb-0"> Amount </h6>
                                    </div>
                                    <div class="col-sm-9 text-secondary">
                                        ${object.amount} 
                                    </div>
                                </div>
                                <hr>
                                <div class="row">
                                    <div class="col-sm-3">
                                        <h6 class="mb-0"> Duration </h6>
                                    </div>
                                    <div class="col-sm-9 text-secondary">
                                        ${object.duration} 
                                    </div>
                                </div>
                                <hr>
                                <div class="row">
                                    <div class="col-sm-3">
                                        <h6 class="mb-0"> Session </h6>
                                    </div>
                                    <div class="col-sm-9 text-secondary">
                                        ${object.session} 
                                    </div>
                                </div>
                                <hr>
                                <div class="row">
                                    <div class="col-sm-3">
                                        <h6 class="mb-0"> Create Date </h6>
                                    </div>
                                    <div class="col-sm-9 text-secondary">
                                        ${object.createdate} 
                                    </div>
                                </div>
                                <hr>
                                <div class="row">
                                    <div class="col-sm-12">
                                        <form action="UserController" method="POST">
                                            <input type="hidden" name="action" value="edit" />
                                            <input type="hidden" name="userID" value="${object.userID}" />
                                            <input type="submit" value="Edit" />
                                        </form>
                                        <!--<a class="btn btn-success" target="__blank" href="UserProfileEditor.jsp">Edit</a>-->
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
        <jsp:include page="../index/UserFooter.jsp" />
    </body>
</html>