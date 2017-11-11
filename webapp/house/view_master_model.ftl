<#import "../taim_template/taims_layout.ftl" as layout>
<@layout.taims_layout  "${(title)!}" >
    <#import "/spring.ftl" as spring/>
    <#assign ctx = rc.getContextPath()/>
    <#assign mModel = mModel/>


<div class="row">
    <div class="col-xs-6">
        <div class="profile-user-info profile-user-info-striped">
            <div class="profile-info-row">
                <div class="profile-info-name"> Sample. No.</div>

                <div class="profile-info-value">
                    <span class="editable" id="username">${mModel.modelNo!}</span>
                </div>
            </div>

            <div class="profile-info-row">
                <div class="profile-info-name"> Sample Name</div>

                <div class="profile-info-value">
                    <span class="editable" id="country">${mModel.modelName!}</span>
                </div>
            </div>
        </div>
    </div>


    <div class="col-xs-6">
        <div class="profile-user-info profile-user-info-striped">
            <div class="profile-info-row">
                <div class="profile-info-name"> Supplier Name</div>

                <div class="profile-info-value">
                    <span class="editable" >${(mModel.supplier.name)!}</span>
                </div>
            </div>
            <div class="profile-info-row">
                <div class="profile-info-name">Record Date</div>

                <div class="profile-info-value">
                    <span class="editable" >${mModel.recordDate!}</span>
                </div>
            </div>

        </div>
    </div>
</div>
<div class="space-8"></div>
<div class="row text-right">
    <div class="col-lg-12">

        <button class="btn btn-white btn-info btn-bold" onclick="window.location = '${ctx}/house/addOrder.ibbl?sampleId=${mModel.id}'">
            <i class="ace-icon glyphicon glyphicon-folder-open bigger-120 blue"></i>
            Add Order
        </button>
        <button class="btn btn-white btn-info btn-bold" onclick="window.location = '${ctx}/house/editSample.ibbl?id=${mModel.id}'">
            <i class="ace-icon glyphicon glyphicon-edit bigger-120 red2"></i>
            Edit
        </button>

    </div>
</div>
<style>.btn:hover, .btn-white:hover, .btn-info:hover, btn-bold:hover {background-color: #c3b18f !important;}</style>
<div class="row">
    <div class="col-sm-6">
        <h5 class="header green lighter smaller">
            <i class="ace-icon fa fa-list smaller-105"></i>
            <b>Sample Life Line</b>
        </h5>


        <div id="accordion" class="accordion-style1">
            <div class="group" style="display: none">
                <h3 class="accordion-header">Sampling Preview</h3>
            </div>
            <div class="group">
                <h3 class="accordion-header" id="first-sampling">1st Sampling</h3>
                <div>
                    <div class="col-lg-12">
                        <p>
                            Mauris mauris ante, blandit et, ultrices a, suscipit eget, quam. Integer
                            ut neque. Vivamus nisi metus, molestie vel, gravida in, condimentum sit
                            amet, nunc. Nam a nibh. Donec suscipit eros. Nam mi. Proin viverra leo ut
                            odio. Curabitur malesuada. Vestibulum a velit eu ante scelerisque vulputate.
                        </p>
                        <button class="btn btn-white btn-info btn-bold"
                                onclick="window.location = '${ctx}/incident/createIncidentReview.ibbl?incidentId=${12}'">
                            <i class="ace-icon fa fa-flag-checkered bigger-120 blue"></i>
                            Create Review
                        </button>
                        <button class="btn btn-white btn-info btn-bold"
                                onclick="window.location = '${ctx}/incident/editIncident.ibbl?id=${12}'">
                            <i class="ace-icon fa fa-pencil-square-o bigger-120 red2"></i>
                            Edit
                        </button>

                    </div>
                </div>
            </div>

            <div class="group">
                <h3 class="accordion-header">2nd Sampling</h3>

                <div>
                    <p>
                        Sed non urna. Donec et ante. Phasellus eu ligula. Vestibulum sit amet
                        purus. Vivamus hendrerit, dolor at aliquet laoreet, mauris turpis porttitor
                        velit, faucibus interdum tellus libero ac justo. Vivamus non quam. In
                        suscipit faucibus urna.
                    </p>
                </div>
            </div>

            <div class="group">
                <h3 class="accordion-header">SS Sampling</h3>

                <div>
                    <p>
                        Nam enim risus, molestie et, porta ac, aliquam ac, risus. Quisque lobortis.
                        Phasellus pellentesque purus in massa. Aenean in pede. Phasellus ac libero
                        ac tellus pellentesque semper. Sed ac felis. Sed commodo, magna quis
                        lacinia ornare, quam ante aliquam nisi, eu iaculis leo purus venenatis dui.
                    </p>

                    <ul>
                        <li>List item one</li>
                        <li>List item two</li>
                        <li>List item three</li>
                    </ul>
                </div>
            </div>

            <#list orderList as order>
                <div class="group">
                    <h3 class="accordion-header">Order No - ${order.info()!}</h3>
                    <div>
                        <p>
                            Mauris mauris ante, blandit et, ultrices a, suscipit eget, quam. Integer
                            ut neque. Vivamus nisi metus, molestie vel, gravida in, condimentum sit
                            amet, nunc. Nam a nibh. Donec suscipit eros. Nam mi. Proin viverra leo ut
                            odio. Curabitur malesuada. Vestibulum a velit eu ante scelerisque vulputate.
                        </p>
                    </div>
                </div>

            </#list>
        </div>


    </div>


</div>

</@layout.taims_layout>
<script>
    //jquery accordion
    $(function () {
//        $("#asdasda").collapse();

        /*$header = $('#first-sampling');
        //getting the next element
        $content = $header.next();
        //open up the content needed - toggle the slide- if visible, slide up, if not slidedown.
        $content.slideToggle(500, function () {
            //execute this after slideToggle is done
            //change text of header based on visibility of content div
            $header.text(function () {
                return $content.is(":visible") ? "Collapse" : "Expand";
            });
        });*/


    });

</script>