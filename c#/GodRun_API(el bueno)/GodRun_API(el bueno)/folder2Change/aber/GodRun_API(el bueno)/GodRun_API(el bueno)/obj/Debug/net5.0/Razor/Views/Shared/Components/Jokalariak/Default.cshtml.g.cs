#pragma checksum "C:\Users\kalboetxeaga.ager\source\repos\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\Shared\Components\Jokalariak\Default.cshtml" "{ff1816ec-aa5e-4d10-87f7-6f4963833460}" "361f7b5625418ddc5a4639502274df5aac67bd2b"
// <auto-generated/>
#pragma warning disable 1591
[assembly: global::Microsoft.AspNetCore.Razor.Hosting.RazorCompiledItemAttribute(typeof(AspNetCore.Views_Shared_Components_Jokalariak_Default), @"mvc.1.0.view", @"/Views/Shared/Components/Jokalariak/Default.cshtml")]
namespace AspNetCore
{
    #line hidden
    using System;
    using System.Collections.Generic;
    using System.Linq;
    using System.Threading.Tasks;
    using Microsoft.AspNetCore.Mvc;
    using Microsoft.AspNetCore.Mvc.Rendering;
    using Microsoft.AspNetCore.Mvc.ViewFeatures;
#nullable restore
#line 1 "C:\Users\kalboetxeaga.ager\source\repos\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\_ViewImports.cshtml"
using GodRun_API_el_bueno_;

#line default
#line hidden
#nullable disable
#nullable restore
#line 2 "C:\Users\kalboetxeaga.ager\source\repos\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\_ViewImports.cshtml"
using GodRun_API_el_bueno_.Models;

#line default
#line hidden
#nullable disable
    [global::Microsoft.AspNetCore.Razor.Hosting.RazorSourceChecksumAttribute(@"SHA1", @"361f7b5625418ddc5a4639502274df5aac67bd2b", @"/Views/Shared/Components/Jokalariak/Default.cshtml")]
    [global::Microsoft.AspNetCore.Razor.Hosting.RazorSourceChecksumAttribute(@"SHA1", @"9b44f7d653bf26fac280a4c5c77f573a77d54be7", @"/Views/_ViewImports.cshtml")]
    public class Views_Shared_Components_Jokalariak_Default : global::Microsoft.AspNetCore.Mvc.Razor.RazorPage<IEnumerable<GodRun_API_el_bueno_.Models.Partida>>
    {
        #pragma warning disable 1998
        public async override global::System.Threading.Tasks.Task ExecuteAsync()
        {
            WriteLiteral("\r\n");
#nullable restore
#line 3 "C:\Users\kalboetxeaga.ager\source\repos\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\Shared\Components\Jokalariak\Default.cshtml"
  
    ViewData["Title"] = "Jokalariak";

#line default
#line hidden
#nullable disable
            WriteLiteral("\r\n\r\n\r\n");
#nullable restore
#line 9 "C:\Users\kalboetxeaga.ager\source\repos\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\Shared\Components\Jokalariak\Default.cshtml"
 foreach (var item in Model)
{
    

#line default
#line hidden
#nullable disable
#nullable restore
#line 11 "C:\Users\kalboetxeaga.ager\source\repos\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\Shared\Components\Jokalariak\Default.cshtml"
     if (item.puntuazioa > 50000)
    {

#line default
#line hidden
#nullable disable
            WriteLiteral("        <a class=\"dropdown-item\">");
#nullable restore
#line 13 "C:\Users\kalboetxeaga.ager\source\repos\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\Shared\Components\Jokalariak\Default.cshtml"
                            Write(Html.DisplayFor(modelItem => item.employee.name));

#line default
#line hidden
#nullable disable
            WriteLiteral(" ->  ");
#nullable restore
#line 13 "C:\Users\kalboetxeaga.ager\source\repos\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\Shared\Components\Jokalariak\Default.cshtml"
                                                                                  Write(Html.DisplayFor(modelItem => item.puntuazioa));

#line default
#line hidden
#nullable disable
            WriteLiteral("</a>\r\n");
#nullable restore
#line 17 "C:\Users\kalboetxeaga.ager\source\repos\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\Shared\Components\Jokalariak\Default.cshtml"
           Write(Html.ActionLink("ikusi", "Index", "Partida_bakoitza", new { puntuazioa = item.puntuazioa, kills = item.kills, time = item.time, date = item.date, izena = item.employee.name, jobTitle = item.employee.jobTitle, workPhone = item.employee.workPhone, workEmail = item.employee.workEmail }));

#line default
#line hidden
#nullable disable
#nullable restore
#line 17 "C:\Users\kalboetxeaga.ager\source\repos\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\Shared\Components\Jokalariak\Default.cshtml"
                                                                                                                                                                                                                                                                                                              
   }

#line default
#line hidden
#nullable disable
#nullable restore
#line 18 "C:\Users\kalboetxeaga.ager\source\repos\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\Shared\Components\Jokalariak\Default.cshtml"
    
        }

#line default
#line hidden
#nullable disable
            WriteLiteral("\r\n\r\n        <!--\r\n        <table class=\"table\">\r\n            <thead>\r\n                <tr>\r\n                    <th>\r\n                        ");
#nullable restore
#line 27 "C:\Users\kalboetxeaga.ager\source\repos\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\Shared\Components\Jokalariak\Default.cshtml"
                   Write(Html.DisplayNameFor(model => model.puntuazioa));

#line default
#line hidden
#nullable disable
            WriteLiteral("\r\n                    </th>\r\n                    <th>\r\n                        ");
#nullable restore
#line 30 "C:\Users\kalboetxeaga.ager\source\repos\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\Shared\Components\Jokalariak\Default.cshtml"
                   Write(Html.DisplayNameFor(model => model.kills));

#line default
#line hidden
#nullable disable
            WriteLiteral("\r\n                    </th>\r\n                    <th>\r\n                        ");
#nullable restore
#line 33 "C:\Users\kalboetxeaga.ager\source\repos\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\Shared\Components\Jokalariak\Default.cshtml"
                   Write(Html.DisplayNameFor(model => model.time));

#line default
#line hidden
#nullable disable
            WriteLiteral("\r\n                    </th>\r\n                    <th>\r\n                        ");
#nullable restore
#line 36 "C:\Users\kalboetxeaga.ager\source\repos\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\Shared\Components\Jokalariak\Default.cshtml"
                   Write(Html.DisplayNameFor(model => model.date));

#line default
#line hidden
#nullable disable
            WriteLiteral("\r\n                    </th>\r\n                    <th></th>\r\n                </tr>\r\n            </thead>\r\n            <tbody>\r\n");
#nullable restore
#line 42 "C:\Users\kalboetxeaga.ager\source\repos\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\Shared\Components\Jokalariak\Default.cshtml"
                 foreach (var item in Model)
                {

#line default
#line hidden
#nullable disable
            WriteLiteral("                    <tr>\r\n                        <td>\r\n                            ");
#nullable restore
#line 46 "C:\Users\kalboetxeaga.ager\source\repos\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\Shared\Components\Jokalariak\Default.cshtml"
                       Write(Html.DisplayFor(modelItem => item.puntuazioa));

#line default
#line hidden
#nullable disable
            WriteLiteral("\r\n                        </td>\r\n                        <td>\r\n                            ");
#nullable restore
#line 49 "C:\Users\kalboetxeaga.ager\source\repos\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\Shared\Components\Jokalariak\Default.cshtml"
                       Write(Html.DisplayFor(modelItem => item.kills));

#line default
#line hidden
#nullable disable
            WriteLiteral("\r\n                        </td>\r\n                        <td>\r\n                            ");
#nullable restore
#line 52 "C:\Users\kalboetxeaga.ager\source\repos\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\Shared\Components\Jokalariak\Default.cshtml"
                       Write(Html.DisplayFor(modelItem => item.time));

#line default
#line hidden
#nullable disable
            WriteLiteral("\r\n                        </td>\r\n                        <td>\r\n                            ");
#nullable restore
#line 55 "C:\Users\kalboetxeaga.ager\source\repos\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\Shared\Components\Jokalariak\Default.cshtml"
                       Write(Html.DisplayFor(modelItem => item.date));

#line default
#line hidden
#nullable disable
            WriteLiteral("\r\n                        </td>\r\n                        <td>\r\n                            ");
#nullable restore
#line 58 "C:\Users\kalboetxeaga.ager\source\repos\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\Shared\Components\Jokalariak\Default.cshtml"
                       Write(Html.ActionLink("Edit", "Edit", new { /* id=item.PrimaryKey */ }));

#line default
#line hidden
#nullable disable
            WriteLiteral(" |\r\n                            ");
#nullable restore
#line 59 "C:\Users\kalboetxeaga.ager\source\repos\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\Shared\Components\Jokalariak\Default.cshtml"
                       Write(Html.ActionLink("Details", "Details", new { /* id=item.PrimaryKey */ }));

#line default
#line hidden
#nullable disable
            WriteLiteral(" |\r\n                            ");
#nullable restore
#line 60 "C:\Users\kalboetxeaga.ager\source\repos\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\Shared\Components\Jokalariak\Default.cshtml"
                       Write(Html.ActionLink("Delete", "Delete", new { /* id=item.PrimaryKey */ }));

#line default
#line hidden
#nullable disable
            WriteLiteral("\r\n                        </td>\r\n                    </tr>\r\n");
#nullable restore
#line 63 "C:\Users\kalboetxeaga.ager\source\repos\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\Shared\Components\Jokalariak\Default.cshtml"
                }

#line default
#line hidden
#nullable disable
            WriteLiteral("            </tbody>\r\n        </table>\r\n            -->\r\n");
        }
        #pragma warning restore 1998
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.ViewFeatures.IModelExpressionProvider ModelExpressionProvider { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.IUrlHelper Url { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.IViewComponentHelper Component { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.Rendering.IJsonHelper Json { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.Rendering.IHtmlHelper<IEnumerable<GodRun_API_el_bueno_.Models.Partida>> Html { get; private set; }
    }
}
#pragma warning restore 1591
