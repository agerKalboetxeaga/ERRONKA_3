#pragma checksum "C:\Users\kalboetxeaga.ager\Desktop\ERRONKA_3\c#\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\Shared\Components\Jokalariak\Default.cshtml" "{ff1816ec-aa5e-4d10-87f7-6f4963833460}" "8b6b1b49a18f42b613b446052013968cb8337c84"
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
#line 1 "C:\Users\kalboetxeaga.ager\Desktop\ERRONKA_3\c#\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\_ViewImports.cshtml"
using GodRun_API_el_bueno_;

#line default
#line hidden
#nullable disable
#nullable restore
#line 2 "C:\Users\kalboetxeaga.ager\Desktop\ERRONKA_3\c#\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\_ViewImports.cshtml"
using GodRun_API_el_bueno_.Models;

#line default
#line hidden
#nullable disable
    [global::Microsoft.AspNetCore.Razor.Hosting.RazorSourceChecksumAttribute(@"SHA1", @"8b6b1b49a18f42b613b446052013968cb8337c84", @"/Views/Shared/Components/Jokalariak/Default.cshtml")]
    [global::Microsoft.AspNetCore.Razor.Hosting.RazorSourceChecksumAttribute(@"SHA1", @"eb050eb90757f832893d31f72cb29792359ca165", @"/Views/_ViewImports.cshtml")]
    public class Views_Shared_Components_Jokalariak_Default : global::Microsoft.AspNetCore.Mvc.Razor.RazorPage<IEnumerable<GodRun_API_el_bueno_.Models.Partida>>
    {
        #pragma warning disable 1998
        public async override global::System.Threading.Tasks.Task ExecuteAsync()
        {
            WriteLiteral("\n");
#nullable restore
#line 3 "C:\Users\kalboetxeaga.ager\Desktop\ERRONKA_3\c#\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\Shared\Components\Jokalariak\Default.cshtml"
  
    ViewData["Title"] = "Jokalariak";

#line default
#line hidden
#nullable disable
            WriteLiteral("\n<!--Component to list all gamers name with its partida´s points-->\n\n");
#nullable restore
#line 9 "C:\Users\kalboetxeaga.ager\Desktop\ERRONKA_3\c#\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\Shared\Components\Jokalariak\Default.cshtml"
 foreach (var item in Model)
{
    

#line default
#line hidden
#nullable disable
#nullable restore
#line 11 "C:\Users\kalboetxeaga.ager\Desktop\ERRONKA_3\c#\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\Shared\Components\Jokalariak\Default.cshtml"
     if (item.puntuazioa > 50000)
    {

#line default
#line hidden
#nullable disable
            WriteLiteral("<a class=\"dropdown-item\">\n    ");
#nullable restore
#line 14 "C:\Users\kalboetxeaga.ager\Desktop\ERRONKA_3\c#\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\Shared\Components\Jokalariak\Default.cshtml"
Write(Html.DisplayFor(modelItem => item.employee.name));

#line default
#line hidden
#nullable disable
            WriteLiteral("-");
#nullable restore
#line 14 "C:\Users\kalboetxeaga.ager\Desktop\ERRONKA_3\c#\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\Shared\Components\Jokalariak\Default.cshtml"
                                                 Write(Html.DisplayFor(modelItem => item.puntuazioa));

#line default
#line hidden
#nullable disable
#nullable restore
#line 14 "C:\Users\kalboetxeaga.ager\Desktop\ERRONKA_3\c#\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\Shared\Components\Jokalariak\Default.cshtml"
                                                                                               Write(Html.ActionLink("ikusi", "Index", "Partida_bakoitza", new { puntuazioa = item.puntuazioa, kills = item.kills, time = item.time, date = item.date, izena = item.employee.name, jobTitle = item.employee.jobTitle, workPhone = item.employee.workPhone, workEmail = item.employee.workEmail }));

#line default
#line hidden
#nullable disable
            WriteLiteral("\n</a>\n");
#nullable restore
#line 16 "C:\Users\kalboetxeaga.ager\Desktop\ERRONKA_3\c#\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\Shared\Components\Jokalariak\Default.cshtml"


    }

#line default
#line hidden
#nullable disable
#nullable restore
#line 18 "C:\Users\kalboetxeaga.ager\Desktop\ERRONKA_3\c#\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\Shared\Components\Jokalariak\Default.cshtml"
     
}

#line default
#line hidden
#nullable disable
            WriteLiteral("\n\n");
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
