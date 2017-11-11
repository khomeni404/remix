<#import "../taim_template/taims_layout.ftl" as layout>
<@layout.taims_layout  "${(title)!}" >
    <#import "/spring.ftl" as spring/>
    <#assign ctx = rc.getContextPath()/>
    <#assign command = Supplier/>

<div class="row">
    <form id="incident-form" action="${ctx}/admin/saveSupplier.ibbl" method="POST" class="form-horizontal"
          role="form">

        <div class="col-xs-6">
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="refNo"> Supplier Name </label>

                <div class="col-sm-9">
                    <@spring.formInput  "Supplier.name" "class='form-control'" />
                    <@spring.showErrors " & ", "err-msg" />
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="incident-type"> Name Sign</label>

                <div class="col-sm-9">
                    <input type="text" class="form-control">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="incident-type"> Address</label>

                <div class="col-sm-9">
                    <input type="text" class="form-control">
                </div>
            </div>



        </div>
        <div class="col-xs-12">
            <div class="col-lg-12">
                <div class="clearfix form-actions">
                    <div class="col-md-offset-3 col-md-9" style="text-align: right">
                        <button class="btn btn-white btn-bold btn-success" type="submit">
                            <i class="ace-icon glyphicon glyphicon-floppy-save bigger-110"></i>
                            Save
                        </button>
                        &nbsp; &nbsp; &nbsp;
                        <button class="btn btn-white btn-bold btn-danger btn-back" type="button" >
                            <i class="ace-icon fa fa-reply-all bigger-110"></i>
                            Back
                        </button>
                    </div>
                </div>
            </div>
        </div>

    </form>
</div>

<div class="row">
    <div class="col-xs-12">
        <table id="simple-table" class="table table-striped table-bordered table-hover">
            <thead>
            <tr>
                <th class="center">
                </th>
                <th>Ref No.</th>
                <th class="hidden-480">Name</th>
                <th class="hidden-480">Address</th>
                <th class="hidden-480">Union Date</th>

                <th></th>
                <th>
                    <i class="ace-icon fa fa-clock-o bigger-110 hidden-480"></i>
                    Update
                </th>
            </tr>
            </thead>

            <tbody>
                <#list supplierList as supplier>
                <tr>
                    <td class="center">
                        <label class="pos-rel">
                            <input type="checkbox" class="ace" />
                            <span class="lbl"></span>
                        </label>
                    </td>

                    <td>${(supplier.id)!}</td>
                    <td>${(supplier.name)!}</td>
                    <td>${'---'}</td>
                    <td>${(supplier.reportingDate)!}</td>

                    <td class="hidden-480">
                        <span class="label label-sm label-warning">Expiring</span>
                    </td>

                    <td>
                        <div class="hidden-sm hidden-xs btn-group">
                            <button class="btn btn-xs btn-success" onclick="window.location = '${ctx}/house/viewSample.ibbl?id=${(supplier.id)!}'">
                                <i class="ace-icon fa fa-eye bigger-120"></i>  View
                            </button>

                            <button class="btn btn-xs btn-info" onclick="window.location = '${ctx}/incident/editIncident.ibbl?id=${supplier.id}'">
                                <i class="ace-icon fa fa-pencil bigger-120"></i>
                            </button>

                            <button class="btn btn-xs btn-danger">
                                <i class="ace-icon fa fa-trash-o bigger-120"></i>
                            </button>

                            <button class="btn btn-xs btn-warning" onclick="window.location = '${ctx}/house/addOrder.ibbl?sampleId=${supplier.id!}'">
                                <i class="ace-icon fa fa-flag bigger-120"></i> Add Order
                            </button>
                        </div>

                        <div class="hidden-md hidden-lg">
                            <div class="inline pos-rel">
                                <button class="btn btn-minier btn-primary dropdown-toggle" data-toggle="dropdown" data-position="auto">
                                    <i class="ace-icon fa fa-cog icon-only bigger-110"></i>
                                </button>

                                <ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
                                    <li>
                                        <a href="#" class="tooltip-info" data-rel="tooltip" title="View">
																			<span class="blue">
																				<i class="ace-icon fa fa-search-plus bigger-120"></i>
																			</span>
                                        </a>
                                    </li>

                                    <li>
                                        <a href="${ctx}/incident/editIncident.ibbl?id=${supplier.id}" class="tooltip-success" data-rel="tooltip" title="Edit">
																			<span class="green">
																				<i class="ace-icon fa fa-pencil-square-o bigger-120">D</i>
																			</span>
                                        </a>
                                    </li>

                                    <li>
                                        <a href="#" class="tooltip-error" data-rel="tooltip" title="Delete">
																			<span class="red">
																				<i class="ace-icon fa fa-trash-o bigger-120"></i>
																			</span>
                                        </a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </td>
                </tr>
                </#list>

            </tbody>
        </table>
    </div><!-- /.span -->
</div>
</@layout.taims_layout>

<style type="text/css">
    .control-label {
        font-weight: bold;
        color: #425d07;
    }

</style>