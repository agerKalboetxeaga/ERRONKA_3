#pragma checksum "C:\Users\kalboetxeaga.ager\Desktop\ERRONKA_3\c#\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\Partida_bakoitza\Index.cshtml" "{ff1816ec-aa5e-4d10-87f7-6f4963833460}" "501d7542595c11da41b7ede91145dd97fa28489e"
// <auto-generated/>
#pragma warning disable 1591
[assembly: global::Microsoft.AspNetCore.Razor.Hosting.RazorCompiledItemAttribute(typeof(AspNetCore.Views_Partida_bakoitza_Index), @"mvc.1.0.view", @"/Views/Partida_bakoitza/Index.cshtml")]
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
    [global::Microsoft.AspNetCore.Razor.Hosting.RazorSourceChecksumAttribute(@"SHA1", @"501d7542595c11da41b7ede91145dd97fa28489e", @"/Views/Partida_bakoitza/Index.cshtml")]
    [global::Microsoft.AspNetCore.Razor.Hosting.RazorSourceChecksumAttribute(@"SHA1", @"eb050eb90757f832893d31f72cb29792359ca165", @"/Views/_ViewImports.cshtml")]
    public class Views_Partida_bakoitza_Index : global::Microsoft.AspNetCore.Mvc.Razor.RazorPage<GodRun_API_el_bueno_.ViewModels.PartidaViewModel>
    {
        #pragma warning disable 1998
        public async override global::System.Threading.Tasks.Task ExecuteAsync()
        {
#nullable restore
#line 2 "C:\Users\kalboetxeaga.ager\Desktop\ERRONKA_3\c#\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\Partida_bakoitza\Index.cshtml"
   ViewData["Title"] = "Index"; 

#line default
#line hidden
#nullable disable
            WriteLiteral(@"
<!--View to display all games made-->

<div class=""container "">
    <h1>Games</h1>
    <table class=""table"">
        <thead class=""thead-dark"">
            <tr>

                <th scope=""col"">Punctuation</th>
                <th scope=""col"">Kills</th>
                <th scope=""col"">Time</th>
                <th scope=""col"">Date</th>
            </tr>
        </thead>





        <tbody>
");
#nullable restore
#line 24 "C:\Users\kalboetxeaga.ager\Desktop\ERRONKA_3\c#\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\Partida_bakoitza\Index.cshtml"
             foreach (var item in Model.partidak)
            {

#line default
#line hidden
#nullable disable
            WriteLiteral("<tr>\n    <th scope=\"row\">");
#nullable restore
#line 27 "C:\Users\kalboetxeaga.ager\Desktop\ERRONKA_3\c#\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\Partida_bakoitza\Index.cshtml"
               Write(Html.DisplayFor(modelItem => item.puntuazioa));

#line default
#line hidden
#nullable disable
            WriteLiteral("</th>\n    <td>");
#nullable restore
#line 28 "C:\Users\kalboetxeaga.ager\Desktop\ERRONKA_3\c#\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\Partida_bakoitza\Index.cshtml"
   Write(Html.DisplayFor(modelItem => item.kills));

#line default
#line hidden
#nullable disable
            WriteLiteral("</td>\n    <td>");
#nullable restore
#line 29 "C:\Users\kalboetxeaga.ager\Desktop\ERRONKA_3\c#\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\Partida_bakoitza\Index.cshtml"
   Write(Html.DisplayFor(modelItem => item.time));

#line default
#line hidden
#nullable disable
            WriteLiteral("</td>\n    <td>");
#nullable restore
#line 30 "C:\Users\kalboetxeaga.ager\Desktop\ERRONKA_3\c#\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\Partida_bakoitza\Index.cshtml"
   Write(Html.DisplayFor(modelItem => item.date));

#line default
#line hidden
#nullable disable
            WriteLiteral("</td>\n</tr>            ");
#nullable restore
#line 31 "C:\Users\kalboetxeaga.ager\Desktop\ERRONKA_3\c#\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\Partida_bakoitza\Index.cshtml"
                 }

#line default
#line hidden
#nullable disable
            WriteLiteral("        </tbody>\n    </table>\n\n\n</div>\n\n");
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
        public global::Microsoft.AspNetCore.Mvc.Rendering.IHtmlHelper<GodRun_API_el_bueno_.ViewModels.PartidaViewModel> Html { get; private set; }
    }
}
#pragma warning restore 1591
