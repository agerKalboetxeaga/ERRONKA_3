#pragma checksum "C:\Users\perez.kepa\KEPA\2EBAL\ERRONKA\ERRONKA_3-main\c#\GodRun_WebApi\GodRun_WebApi\Pages\Shared\Components\Partidak\Default.cshtml" "{ff1816ec-aa5e-4d10-87f7-6f4963833460}" "b3114a987cdfe49cbe665b2a85e37aaf135f38e3"
// <auto-generated/>
#pragma warning disable 1591
[assembly: global::Microsoft.AspNetCore.Razor.Hosting.RazorCompiledItemAttribute(typeof(GodRun_WebApi.Pages.Shared.Components.Partidak.Pages_Shared_Components_Partidak_Default), @"mvc.1.0.view", @"/Pages/Shared/Components/Partidak/Default.cshtml")]
namespace GodRun_WebApi.Pages.Shared.Components.Partidak
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
#line 1 "C:\Users\perez.kepa\KEPA\2EBAL\ERRONKA\ERRONKA_3-main\c#\GodRun_WebApi\GodRun_WebApi\Pages\_ViewImports.cshtml"
using Microsoft.AspNetCore.Identity;

#line default
#line hidden
#nullable disable
#nullable restore
#line 2 "C:\Users\perez.kepa\KEPA\2EBAL\ERRONKA\ERRONKA_3-main\c#\GodRun_WebApi\GodRun_WebApi\Pages\_ViewImports.cshtml"
using GodRun_WebApi;

#line default
#line hidden
#nullable disable
#nullable restore
#line 3 "C:\Users\perez.kepa\KEPA\2EBAL\ERRONKA\ERRONKA_3-main\c#\GodRun_WebApi\GodRun_WebApi\Pages\_ViewImports.cshtml"
using GodRun_WebApi.Data;

#line default
#line hidden
#nullable disable
    [global::Microsoft.AspNetCore.Razor.Hosting.RazorSourceChecksumAttribute(@"SHA1", @"b3114a987cdfe49cbe665b2a85e37aaf135f38e3", @"/Pages/Shared/Components/Partidak/Default.cshtml")]
    [global::Microsoft.AspNetCore.Razor.Hosting.RazorSourceChecksumAttribute(@"SHA1", @"e52ae3eb149aa2a3c7b0c749cafae74c7aebb725", @"/Pages/_ViewImports.cshtml")]
    public class Pages_Shared_Components_Partidak_Default : global::Microsoft.AspNetCore.Mvc.Razor.RazorPage<IEnumerable<GodRun_WebApi.Models.Partida>>
    {
        #pragma warning disable 1998
        public async override global::System.Threading.Tasks.Task ExecuteAsync()
        {
            WriteLiteral("\n");
#nullable restore
#line 3 "C:\Users\perez.kepa\KEPA\2EBAL\ERRONKA\ERRONKA_3-main\c#\GodRun_WebApi\GodRun_WebApi\Pages\Shared\Components\Partidak\Default.cshtml"
  
    ViewData["Title"] = "Partidak";

#line default
#line hidden
#nullable disable
            WriteLiteral("\n\n<ul class=\"dropdown-menu\">\n    <li>\n        <div class=\"container padinaMenu\">\n            <div class=\"col-md4 nireMenua\">\n                <h5 class=\"borgona\">Players: </h5>\n");
#nullable restore
#line 13 "C:\Users\perez.kepa\KEPA\2EBAL\ERRONKA\ERRONKA_3-main\c#\GodRun_WebApi\GodRun_WebApi\Pages\Shared\Components\Partidak\Default.cshtml"
                 foreach (var item in Model)
                {
                    

#line default
#line hidden
#nullable disable
#nullable restore
#line 15 "C:\Users\perez.kepa\KEPA\2EBAL\ERRONKA\ERRONKA_3-main\c#\GodRun_WebApi\GodRun_WebApi\Pages\Shared\Components\Partidak\Default.cshtml"
                     if (item.puntuazioa > 50000)
                    {

#line default
#line hidden
#nullable disable
            WriteLiteral("                        <a href=\"#\">");
#nullable restore
#line 17 "C:\Users\perez.kepa\KEPA\2EBAL\ERRONKA\ERRONKA_3-main\c#\GodRun_WebApi\GodRun_WebApi\Pages\Shared\Components\Partidak\Default.cshtml"
                               Write(Html.DisplayFor(modelItem => item.employee.name));

#line default
#line hidden
#nullable disable
            WriteLiteral("</a>\n");
#nullable restore
#line 18 "C:\Users\perez.kepa\KEPA\2EBAL\ERRONKA\ERRONKA_3-main\c#\GodRun_WebApi\GodRun_WebApi\Pages\Shared\Components\Partidak\Default.cshtml"
                    }

#line default
#line hidden
#nullable disable
#nullable restore
#line 18 "C:\Users\perez.kepa\KEPA\2EBAL\ERRONKA\ERRONKA_3-main\c#\GodRun_WebApi\GodRun_WebApi\Pages\Shared\Components\Partidak\Default.cshtml"
                     
                }

#line default
#line hidden
#nullable disable
            WriteLiteral("            </div>\n        </div>\n    </li>\n</ul>\n\n<!--\n<table class=\"table\">\n    <thead>\n        <tr>\n            <th>\n                ");
#nullable restore
#line 30 "C:\Users\perez.kepa\KEPA\2EBAL\ERRONKA\ERRONKA_3-main\c#\GodRun_WebApi\GodRun_WebApi\Pages\Shared\Components\Partidak\Default.cshtml"
           Write(Html.DisplayNameFor(model => model.puntuazioa));

#line default
#line hidden
#nullable disable
            WriteLiteral("\n            </th>\n            <th>\n                ");
#nullable restore
#line 33 "C:\Users\perez.kepa\KEPA\2EBAL\ERRONKA\ERRONKA_3-main\c#\GodRun_WebApi\GodRun_WebApi\Pages\Shared\Components\Partidak\Default.cshtml"
           Write(Html.DisplayNameFor(model => model.kills));

#line default
#line hidden
#nullable disable
            WriteLiteral("\n            </th>\n            <th>\n                ");
#nullable restore
#line 36 "C:\Users\perez.kepa\KEPA\2EBAL\ERRONKA\ERRONKA_3-main\c#\GodRun_WebApi\GodRun_WebApi\Pages\Shared\Components\Partidak\Default.cshtml"
           Write(Html.DisplayNameFor(model => model.time));

#line default
#line hidden
#nullable disable
            WriteLiteral("\n            </th>\n            <th>\n                ");
#nullable restore
#line 39 "C:\Users\perez.kepa\KEPA\2EBAL\ERRONKA\ERRONKA_3-main\c#\GodRun_WebApi\GodRun_WebApi\Pages\Shared\Components\Partidak\Default.cshtml"
           Write(Html.DisplayNameFor(model => model.date));

#line default
#line hidden
#nullable disable
            WriteLiteral("\n            </th>\n            <th></th>\n        </tr>\n    </thead>\n    <tbody>\n");
#nullable restore
#line 45 "C:\Users\perez.kepa\KEPA\2EBAL\ERRONKA\ERRONKA_3-main\c#\GodRun_WebApi\GodRun_WebApi\Pages\Shared\Components\Partidak\Default.cshtml"
         foreach (var item in Model)
        {

#line default
#line hidden
#nullable disable
            WriteLiteral("            <tr>\n                <td>\n                    ");
#nullable restore
#line 49 "C:\Users\perez.kepa\KEPA\2EBAL\ERRONKA\ERRONKA_3-main\c#\GodRun_WebApi\GodRun_WebApi\Pages\Shared\Components\Partidak\Default.cshtml"
               Write(Html.DisplayFor(modelItem => item.puntuazioa));

#line default
#line hidden
#nullable disable
            WriteLiteral("\n                </td>\n                <td>\n                    ");
#nullable restore
#line 52 "C:\Users\perez.kepa\KEPA\2EBAL\ERRONKA\ERRONKA_3-main\c#\GodRun_WebApi\GodRun_WebApi\Pages\Shared\Components\Partidak\Default.cshtml"
               Write(Html.DisplayFor(modelItem => item.kills));

#line default
#line hidden
#nullable disable
            WriteLiteral("\n                </td>\n                <td>\n                    ");
#nullable restore
#line 55 "C:\Users\perez.kepa\KEPA\2EBAL\ERRONKA\ERRONKA_3-main\c#\GodRun_WebApi\GodRun_WebApi\Pages\Shared\Components\Partidak\Default.cshtml"
               Write(Html.DisplayFor(modelItem => item.time));

#line default
#line hidden
#nullable disable
            WriteLiteral("\n                </td>\n                <td>\n                    ");
#nullable restore
#line 58 "C:\Users\perez.kepa\KEPA\2EBAL\ERRONKA\ERRONKA_3-main\c#\GodRun_WebApi\GodRun_WebApi\Pages\Shared\Components\Partidak\Default.cshtml"
               Write(Html.DisplayFor(modelItem => item.date));

#line default
#line hidden
#nullable disable
            WriteLiteral("\n                </td>\n                <td>\n                    ");
#nullable restore
#line 61 "C:\Users\perez.kepa\KEPA\2EBAL\ERRONKA\ERRONKA_3-main\c#\GodRun_WebApi\GodRun_WebApi\Pages\Shared\Components\Partidak\Default.cshtml"
               Write(Html.ActionLink("Edit", "Edit", new { /* id=item.PrimaryKey */ }));

#line default
#line hidden
#nullable disable
            WriteLiteral(" |\n                    ");
#nullable restore
#line 62 "C:\Users\perez.kepa\KEPA\2EBAL\ERRONKA\ERRONKA_3-main\c#\GodRun_WebApi\GodRun_WebApi\Pages\Shared\Components\Partidak\Default.cshtml"
               Write(Html.ActionLink("Details", "Details", new { /* id=item.PrimaryKey */ }));

#line default
#line hidden
#nullable disable
            WriteLiteral(" |\n                    ");
#nullable restore
#line 63 "C:\Users\perez.kepa\KEPA\2EBAL\ERRONKA\ERRONKA_3-main\c#\GodRun_WebApi\GodRun_WebApi\Pages\Shared\Components\Partidak\Default.cshtml"
               Write(Html.ActionLink("Delete", "Delete", new { /* id=item.PrimaryKey */ }));

#line default
#line hidden
#nullable disable
            WriteLiteral("\n                </td>\n            </tr>\n");
#nullable restore
#line 66 "C:\Users\perez.kepa\KEPA\2EBAL\ERRONKA\ERRONKA_3-main\c#\GodRun_WebApi\GodRun_WebApi\Pages\Shared\Components\Partidak\Default.cshtml"
        }

#line default
#line hidden
#nullable disable
            WriteLiteral("    </tbody>\n</table>\n    -->");
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
        public global::Microsoft.AspNetCore.Mvc.Rendering.IHtmlHelper<IEnumerable<GodRun_WebApi.Models.Partida>> Html { get; private set; }
    }
}
#pragma warning restore 1591
