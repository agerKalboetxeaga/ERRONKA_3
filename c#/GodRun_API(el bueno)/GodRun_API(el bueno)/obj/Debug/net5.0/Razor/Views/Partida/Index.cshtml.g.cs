#pragma checksum "C:\Users\perez.kepa\KEPA\2EBAL\ERRONKA\Git hb\ERRONKA_3\c#\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\Partida\Index.cshtml" "{ff1816ec-aa5e-4d10-87f7-6f4963833460}" "df65731bc82fcc2e5e6e029a0fd8c2c85c33f3a8"
// <auto-generated/>
#pragma warning disable 1591
[assembly: global::Microsoft.AspNetCore.Razor.Hosting.RazorCompiledItemAttribute(typeof(AspNetCore.Views_Partida_Index), @"mvc.1.0.view", @"/Views/Partida/Index.cshtml")]
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
#line 1 "C:\Users\perez.kepa\KEPA\2EBAL\ERRONKA\Git hb\ERRONKA_3\c#\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\_ViewImports.cshtml"
using GodRun_API_el_bueno_;

#line default
#line hidden
#nullable disable
#nullable restore
#line 2 "C:\Users\perez.kepa\KEPA\2EBAL\ERRONKA\Git hb\ERRONKA_3\c#\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\_ViewImports.cshtml"
using GodRun_API_el_bueno_.Models;

#line default
#line hidden
#nullable disable
    [global::Microsoft.AspNetCore.Razor.Hosting.RazorSourceChecksumAttribute(@"SHA1", @"df65731bc82fcc2e5e6e029a0fd8c2c85c33f3a8", @"/Views/Partida/Index.cshtml")]
    [global::Microsoft.AspNetCore.Razor.Hosting.RazorSourceChecksumAttribute(@"SHA1", @"9b44f7d653bf26fac280a4c5c77f573a77d54be7", @"/Views/_ViewImports.cshtml")]
    public class Views_Partida_Index : global::Microsoft.AspNetCore.Mvc.Razor.RazorPage<GodRun_WebApi.ViewModels.PartidaViewModel>
    {
        #pragma warning disable 1998
        public async override global::System.Threading.Tasks.Task ExecuteAsync()
        {
#nullable restore
#line 2 "C:\Users\perez.kepa\KEPA\2EBAL\ERRONKA\Git hb\ERRONKA_3\c#\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\Partida\Index.cshtml"
  
    ViewData["Title"] = "Index";

#line default
#line hidden
#nullable disable
            WriteLiteral(@"
<h1>

    </h1>










<div class=""container "">
    <h1>Partidas</h1>
    <table class=""table"">
        <thead class=""thead-dark"">
            <tr>

                <th scope=""col"">puntuazioa</th>
                <th scope=""col"">kills</th>
                <th scope=""col"">time</th>
                <th scope=""col"">date</th>
            </tr>
        </thead>





        <tbody>
");
#nullable restore
#line 37 "C:\Users\perez.kepa\KEPA\2EBAL\ERRONKA\Git hb\ERRONKA_3\c#\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\Partida\Index.cshtml"
             foreach (var item in Model.partidak)
            {

#line default
#line hidden
#nullable disable
            WriteLiteral("                <tr>\r\n                    <th scope=\"row\">");
#nullable restore
#line 40 "C:\Users\perez.kepa\KEPA\2EBAL\ERRONKA\Git hb\ERRONKA_3\c#\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\Partida\Index.cshtml"
                               Write(Html.DisplayFor(modelItem => item.puntuazioa));

#line default
#line hidden
#nullable disable
            WriteLiteral("</th>\r\n                     <td>");
#nullable restore
#line 41 "C:\Users\perez.kepa\KEPA\2EBAL\ERRONKA\Git hb\ERRONKA_3\c#\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\Partida\Index.cshtml"
                    Write(Html.DisplayFor(modelItem => item.kills));

#line default
#line hidden
#nullable disable
            WriteLiteral("</td>\r\n                    <td>");
#nullable restore
#line 42 "C:\Users\perez.kepa\KEPA\2EBAL\ERRONKA\Git hb\ERRONKA_3\c#\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\Partida\Index.cshtml"
                   Write(Html.DisplayFor(modelItem => item.time));

#line default
#line hidden
#nullable disable
            WriteLiteral("</td>\r\n                    <td>");
#nullable restore
#line 43 "C:\Users\perez.kepa\KEPA\2EBAL\ERRONKA\Git hb\ERRONKA_3\c#\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\Partida\Index.cshtml"
                   Write(Html.DisplayFor(modelItem => item.date));

#line default
#line hidden
#nullable disable
            WriteLiteral("</td>\r\n                </tr>\r\n");
#nullable restore
#line 45 "C:\Users\perez.kepa\KEPA\2EBAL\ERRONKA\Git hb\ERRONKA_3\c#\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\Partida\Index.cshtml"
            }

#line default
#line hidden
#nullable disable
            WriteLiteral("            </tbody>\r\n    </table>\r\n\r\n\r\n</div>\r\n");
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
        public global::Microsoft.AspNetCore.Mvc.Rendering.IHtmlHelper<GodRun_WebApi.ViewModels.PartidaViewModel> Html { get; private set; }
    }
}
#pragma warning restore 1591
