<#import "../taim_template/taims_layout.ftl" as layout>
<@layout.taims_layout  "${(title)!}" >
    <#import "/spring.ftl" as spring/>
    <#assign ctx = rc.getContextPath()/>

<#--<@spring.showErrors "<br>" />
    <@spring.showErrors "incident.refNo", "error" />
    <br>-->

<#--<form action="${ctx}/test/catchForm.ibbl" method="POST">-->
<form action="${ctx}/test/beanValidation.ibbl" method="POST">
    <div class="row">
        <div class="col-xs-6">

            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="refNo"> Reference No </label>

                <div class="col-sm-9">
                <#--<@spring.bind "incident.refNo"/>-->
                    <@spring.formInput  "incident.refNo" "class='form-control'" />
                    <#list spring.status.errorMessages as error> <b>${error}</b> <br> </#list>
                </div>
            </div>


            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="details">Details </label>
                <div class="col-sm-9">
                <#--<@spring.bind "incident.details"/>-->
                    <@spring.formInput  "incident.details" "class='form-control'" />
                    <#list spring.status.errorMessages as error> <b>${error}</b> <br> </#list>
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="incident-type"> Incident Type</label>

                <div class="col-sm-9">
                    <@spring.formSingleSelect "incident.type", typeMap,  "class='form-control'"/>
                    <#list spring.status.errorMessages as error> <b>${error}</b> <br> </#list>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="incident-type">Has Controlling Ap</label>

                <#--<div class="col-sm-9">
                    <@spring.formCheckbox "incident.noControllingApparatus", " class='ace ace-checkbox-2' onclick=''"/>
                    <#list spring.status.errorMessages as error> <b>${error}</b> <br> </#list>
                </div>-->
            </div>


            <div class="clearfix form-actions">
                <div class="col-md-offset-3 col-md-9">
                    <button class="btn btn-info" type="submit">
                        <i class="ace-icon fa fa-check bigger-110"></i>
                        Submit
                    </button>

                    &nbsp; &nbsp; &nbsp;
                    <button class="btn" type="reset">
                        <i class="ace-icon fa fa-undo bigger-110"></i>
                        Reset
                    </button>
                </div>
            </div>
        </div>

    </div>
</form>

<#--<form action="" method="POST">-->

<#--<dd><@spring.formInput "user.email" />
    <dd><@spring.showErrors "<br>" />
    <dt>Password:</dt>
    <dd><@spring.formPasswordInput "user.passwort" />
    <dd><@spring.showErrors "<br>" />
    <dt>Password verification:</dt>
    <dd><input type="password" name="passVerification"/>
    <dd><@spring.showErrors "<br>" />
    <dt>Should the User have administrator rights?</dt>
    <dd><input type="checkbox" name="isAdmin"/>
    <dd><@spring.showErrors "<br>" />
        <br>-->




</@layout.taims_layout>
