[#ftl/]
[#import "spring.ftl" as spring /]
[#--[#import "panda.ftl" as panda /]--]

[#--[#import "discoveryProject.ftl" as discoveryProject/]--]

[#macro defineProjectForm newProject]
    [@spring.bind "discoveryProjectDetailsBean"/]

    [#if newProject?has_content && newProject =="true"]
    <table class="transparentTable">
        <tr>
            <!--Left Part-->
            <td>
                <table>
                    <tr>
                        <td>
                            [@spring.showErrors " " "errors"/]
                            <span>Data Source<sup><span style="color: red; ">*</span></sup></span>
                        </td>
                        <td>
                            [@spring.bind "dataSources"/]
                [@spring.formSingleSelect "discoveryProjectDetailsBean.discoveryProjectBean.dataSource" dataSources "disabled='disabled' multiple='multiple' class='singleList' onchange='checkValidations()'" /]

                        </td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
    [/#if]
[/#macro]