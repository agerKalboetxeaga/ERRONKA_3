#pragma checksum "C:\Users\kalboetxeaga.ager\source\repos\GodRun_WebApi\GodRun_WebApi\Views\Shared\Partidak\Default.cshtml" "{ff1816ec-aa5e-4d10-87f7-6f4963833460}" "a24a3bfa2e4309e7525b07a0f283826f92e874c0"
// <auto-generated/>
#pragma warning disable 1591
[assembly: global::Microsoft.AspNetCore.Razor.Hosting.RazorCompiledItemAttribute(typeof(AspNetCore.Views_Shared_Partidak_Default), @"mvc.1.0.view", @"/Views/Shared/Partidak/Default.cshtml")]
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
    [global::Microsoft.AspNetCore.Razor.Hosting.RazorSourceChecksumAttribute(@"SHA1", @"a24a3bfa2e4309e7525b07a0f283826f92e874c0", @"/Views/Shared/Partidak/Default.cshtml")]
    public class Views_Shared_Partidak_Default : global::Microsoft.AspNetCore.Mvc.Razor.RazorPage<IEnumerable<GodRun_WebApi.Models.Partida>>
    {
        #pragma warning disable 1998
        public async override global::System.Threading.Tasks.Task ExecuteAsync()
        {
            WriteLiteral("\r\n");
#nullable restore
#line 3 "C:\Users\kalboetxeaga.ager\source\repos\GodRun_WebApi\GodRun_WebApi\Views\Shared\Partidak\Default.cshtml"
  
    ViewData["Title"] = "Partidakkk";

#line default
#line hidden
#nullable disable
            WriteLiteral("\r\n<h1>Mira las partidas nene</h1>\r\n\r\n<ul class=\"dropsown-menu\">\r\n");
#nullable restore
#line 10 "C:\Users\kalboetxeaga.ager\source\repos\GodRun_WebApi\GodRun_WebApi\Views\Shared\Partidak\Default.cshtml"
     foreach(var item in Model)
            {
        

#line default
#line hidden
#nullable disable
#nullable restore
#line 12 "C:\Users\kalboetxeaga.ager\source\repos\GodRun_WebApi\GodRun_WebApi\Views\Shared\Partidak\Default.cshtml"
         if(item.puntuazioa > 500000)
                {

#line default
#line hidden
#nullable disable
            WriteLiteral("                    <il><a href=\"#\">");
#nullable restore
#line 14 "C:\Users\kalboetxeaga.ager\source\repos\GodRun_WebApi\GodRun_WebApi\Views\Shared\Partidak\Default.cshtml"
                               Write(Html.DisplayFor(modelItem => item.puntuazioa));

#line default
#line hidden
#nullable disable
            WriteLiteral("</a> </il>\r\n");
#nullable restore
#line 15 "C:\Users\kalboetxeaga.ager\source\repos\GodRun_WebApi\GodRun_WebApi\Views\Shared\Partidak\Default.cshtml"
                }

#line default
#line hidden
#nullable disable
#nullable restore
#line 15 "C:\Users\kalboetxeaga.ager\source\repos\GodRun_WebApi\GodRun_WebApi\Views\Shared\Partidak\Default.cshtml"
                 
                
            }

#line default
#line hidden
#nullable disable
            WriteLiteral("</ul>\r\n\r\n\r\n\r\n\r\n<!--\r\n<p>\r\n    <a asp-action=\"Create\">Create New</a>\r\n</p>\r\n<table class=\"table\">\r\n    <thead>\r\n        <tr>\r\n            <th>\r\n                ");
#nullable restore
#line 31 "C:\Users\kalboetxeaga.ager\source\repos\GodRun_WebApi\GodRun_WebApi\Views\Shared\Partidak\Default.cshtml"
           Write(Html.DisplayNameFor(model => model.puntuazioa));

#line default
#line hidden
#nullable disable
            WriteLiteral("\r\n            </th>\r\n            <th>\r\n                ");
#nullable restore
#line 34 "C:\Users\kalboetxeaga.ager\source\repos\GodRun_WebApi\GodRun_WebApi\Views\Shared\Partidak\Default.cshtml"
           Write(Html.DisplayNameFor(model => model.kills));

#line default
#line hidden
#nullable disable
            WriteLiteral("\r\n            </th>\r\n            <th>\r\n                ");
#nullable restore
#line 37 "C:\Users\kalboetxeaga.ager\source\repos\GodRun_WebApi\GodRun_WebApi\Views\Shared\Partidak\Default.cshtml"
           Write(Html.DisplayNameFor(model => model.time));

#line default
#line hidden
#nullable disable
            WriteLiteral("\r\n            </th>\r\n            <th>\r\n                ");
#nullable restore
#line 40 "C:\Users\kalboetxeaga.ager\source\repos\GodRun_WebApi\GodRun_WebApi\Views\Shared\Partidak\Default.cshtml"
           Write(Html.DisplayNameFor(model => model.date));

#line default
#line hidden
#nullable disable
            WriteLiteral("\r\n            </th>\r\n            <th></th>\r\n        </tr>\r\n    </thead>\r\n    <tbody>\r\n");
#nullable restore
#line 46 "C:\Users\kalboetxeaga.ager\source\repos\GodRun_WebApi\GodRun_WebApi\Views\Shared\Partidak\Default.cshtml"
 foreach (var item in Model) {

#line default
#line hidden
#nullable disable
            WriteLiteral("        <tr>\r\n            <td>\r\n                ");
#nullable restore
#line 49 "C:\Users\kalboetxeaga.ager\source\repos\GodRun_WebApi\GodRun_WebApi\Views\Shared\Partidak\Default.cshtml"
           Write(Html.DisplayFor(modelItem => item.puntuazioa));

#line default
#line hidden
#nullable disable
            WriteLiteral("\r\n            </td>\r\n            <td>\r\n                ");
#nullable restore
#line 52 "C:\Users\kalboetxeaga.ager\source\repos\GodRun_WebApi\GodRun_WebApi\Views\Shared\Partidak\Default.cshtml"
           Write(Html.DisplayFor(modelItem => item.kills));

#line default
#line hidden
#nullable disable
            WriteLiteral("\r\n            </td>\r\n            <td>\r\n                ");
#nullable restore
#line 55 "C:\Users\kalboetxeaga.ager\source\repos\GodRun_WebApi\GodRun_WebApi\Views\Shared\Partidak\Default.cshtml"
           Write(Html.DisplayFor(modelItem => item.time));

#line default
#line hidden
#nullable disable
            WriteLiteral("\r\n            </td>\r\n            <td>\r\n                ");
#nullable restore
#line 58 "C:\Users\kalboetxeaga.ager\source\repos\GodRun_WebApi\GodRun_WebApi\Views\Shared\Partidak\Default.cshtml"
           Write(Html.DisplayFor(modelItem => item.date));

#line default
#line hidden
#nullable disable
            WriteLiteral("\r\n            </td>\r\n            <td>\r\n                ");
#nullable restore
#line 61 "C:\Users\kalboetxeaga.ager\source\repos\GodRun_WebApi\GodRun_WebApi\Views\Shared\Partidak\Default.cshtml"
           Write(Html.ActionLink("Edit", "Edit", new { /* id=item.PrimaryKey */ }));

#line default
#line hidden
#nullable disable
            WriteLiteral(" |\r\n                ");
#nullable restore
#line 62 "C:\Users\kalboetxeaga.ager\source\repos\GodRun_WebApi\GodRun_WebApi\Views\Shared\Partidak\Default.cshtml"
           Write(Html.ActionLink("Details", "Details", new { /* id=item.PrimaryKey */ }));

#line default
#line hidden
#nullable disable
            WriteLiteral(" |\r\n                ");
#nullable restore
#line 63 "C:\Users\kalboetxeaga.ager\source\repos\GodRun_WebApi\GodRun_WebApi\Views\Shared\Partidak\Default.cshtml"
           Write(Html.ActionLink("Delete", "Delete", new { /* id=item.PrimaryKey */ }));

#line default
#line hidden
#nullable disable
            WriteLiteral("\r\n            </td>\r\n        </tr>\r\n");
#nullable restore
#line 66 "C:\Users\kalboetxeaga.ager\source\repos\GodRun_WebApi\GodRun_WebApi\Views\Shared\Partidak\Default.cshtml"
}

#line default
#line hidden
#nullable disable
            WriteLiteral("    </tbody>\r\n</table>\r\n    -->");
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
