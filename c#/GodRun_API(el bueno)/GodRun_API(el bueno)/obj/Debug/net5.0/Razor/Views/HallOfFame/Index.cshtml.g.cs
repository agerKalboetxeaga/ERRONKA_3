#pragma checksum "C:\Users\perez.kepa\KEPA\2EBAL\ERRONKA\Git hb\version\ERRONKA_3\c#\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\HallOfFame\Index.cshtml" "{ff1816ec-aa5e-4d10-87f7-6f4963833460}" "d04ad72219501e3ebee8513a8763e13950dfc8a0"
// <auto-generated/>
#pragma warning disable 1591
[assembly: global::Microsoft.AspNetCore.Razor.Hosting.RazorCompiledItemAttribute(typeof(AspNetCore.Views_HallOfFame_Index), @"mvc.1.0.view", @"/Views/HallOfFame/Index.cshtml")]
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
#line 1 "C:\Users\perez.kepa\KEPA\2EBAL\ERRONKA\Git hb\version\ERRONKA_3\c#\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\_ViewImports.cshtml"
using GodRun_API_el_bueno_;

#line default
#line hidden
#nullable disable
#nullable restore
#line 2 "C:\Users\perez.kepa\KEPA\2EBAL\ERRONKA\Git hb\version\ERRONKA_3\c#\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\_ViewImports.cshtml"
using GodRun_API_el_bueno_.Models;

#line default
#line hidden
#nullable disable
    [global::Microsoft.AspNetCore.Razor.Hosting.RazorSourceChecksumAttribute(@"SHA1", @"d04ad72219501e3ebee8513a8763e13950dfc8a0", @"/Views/HallOfFame/Index.cshtml")]
    [global::Microsoft.AspNetCore.Razor.Hosting.RazorSourceChecksumAttribute(@"SHA1", @"9b44f7d653bf26fac280a4c5c77f573a77d54be7", @"/Views/_ViewImports.cshtml")]
    public class Views_HallOfFame_Index : global::Microsoft.AspNetCore.Mvc.Razor.RazorPage<GodRun_WebApi.ViewModels.PartidaViewModel>
    {
        private static readonly global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute __tagHelperAttribute_0 = new global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute("asp-action", "Create", global::Microsoft.AspNetCore.Razor.TagHelpers.HtmlAttributeValueStyle.DoubleQuotes);
        #line hidden
        #pragma warning disable 0649
        private global::Microsoft.AspNetCore.Razor.Runtime.TagHelpers.TagHelperExecutionContext __tagHelperExecutionContext;
        #pragma warning restore 0649
        private global::Microsoft.AspNetCore.Razor.Runtime.TagHelpers.TagHelperRunner __tagHelperRunner = new global::Microsoft.AspNetCore.Razor.Runtime.TagHelpers.TagHelperRunner();
        #pragma warning disable 0169
        private string __tagHelperStringValueBuffer;
        #pragma warning restore 0169
        private global::Microsoft.AspNetCore.Razor.Runtime.TagHelpers.TagHelperScopeManager __backed__tagHelperScopeManager = null;
        private global::Microsoft.AspNetCore.Razor.Runtime.TagHelpers.TagHelperScopeManager __tagHelperScopeManager
        {
            get
            {
                if (__backed__tagHelperScopeManager == null)
                {
                    __backed__tagHelperScopeManager = new global::Microsoft.AspNetCore.Razor.Runtime.TagHelpers.TagHelperScopeManager(StartTagHelperWritingScope, EndTagHelperWritingScope);
                }
                return __backed__tagHelperScopeManager;
            }
        }
        private global::Microsoft.AspNetCore.Mvc.TagHelpers.AnchorTagHelper __Microsoft_AspNetCore_Mvc_TagHelpers_AnchorTagHelper;
        #pragma warning disable 1998
        public async override global::System.Threading.Tasks.Task ExecuteAsync()
        {
#nullable restore
#line 2 "C:\Users\perez.kepa\KEPA\2EBAL\ERRONKA\Git hb\version\ERRONKA_3\c#\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\HallOfFame\Index.cshtml"
  
    ViewData["Title"] = "Index";

#line default
#line hidden
#nullable disable
            WriteLiteral("\r\n<h1>Index</h1>\r\n\r\n<p>\r\n    ");
            __tagHelperExecutionContext = __tagHelperScopeManager.Begin("a", global::Microsoft.AspNetCore.Razor.TagHelpers.TagMode.StartTagAndEndTag, "d04ad72219501e3ebee8513a8763e13950dfc8a03901", async() => {
                WriteLiteral("Create New");
            }
            );
            __Microsoft_AspNetCore_Mvc_TagHelpers_AnchorTagHelper = CreateTagHelper<global::Microsoft.AspNetCore.Mvc.TagHelpers.AnchorTagHelper>();
            __tagHelperExecutionContext.Add(__Microsoft_AspNetCore_Mvc_TagHelpers_AnchorTagHelper);
            __Microsoft_AspNetCore_Mvc_TagHelpers_AnchorTagHelper.Action = (string)__tagHelperAttribute_0.Value;
            __tagHelperExecutionContext.AddTagHelperAttribute(__tagHelperAttribute_0);
            await __tagHelperRunner.RunAsync(__tagHelperExecutionContext);
            if (!__tagHelperExecutionContext.Output.IsContentModified)
            {
                await __tagHelperExecutionContext.SetOutputContentAsync();
            }
            Write(__tagHelperExecutionContext.Output);
            __tagHelperExecutionContext = __tagHelperScopeManager.End();
            WriteLiteral(@"
</p>
<table class=""table"">
    <thead>
        <tr>
            <th>
                <p>puntuazioa</p>
            </th>
            <th>
                <p>kills</p>
            </th>
            <th>
                <p>time</p>
            </th>
            <th>
                <p>date</p>
            </th>
            <th></th>
        </tr>
    </thead>
    <tbody>
");
#nullable restore
#line 30 "C:\Users\perez.kepa\KEPA\2EBAL\ERRONKA\Git hb\version\ERRONKA_3\c#\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\HallOfFame\Index.cshtml"
         if (Model.partidak.Count <= 10)
        {
            

#line default
#line hidden
#nullable disable
#nullable restore
#line 32 "C:\Users\perez.kepa\KEPA\2EBAL\ERRONKA\Git hb\version\ERRONKA_3\c#\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\HallOfFame\Index.cshtml"
             foreach (var item in Model.partidak.OrderByDescending(a => a.puntuazioa))
            {

#line default
#line hidden
#nullable disable
            WriteLiteral("                <tr>\r\n                    <td>\r\n                        ");
#nullable restore
#line 36 "C:\Users\perez.kepa\KEPA\2EBAL\ERRONKA\Git hb\version\ERRONKA_3\c#\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\HallOfFame\Index.cshtml"
                   Write(Html.DisplayFor(modelItem => item.puntuazioa));

#line default
#line hidden
#nullable disable
            WriteLiteral("\r\n                    </td>\r\n                    <td>\r\n                        ");
#nullable restore
#line 39 "C:\Users\perez.kepa\KEPA\2EBAL\ERRONKA\Git hb\version\ERRONKA_3\c#\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\HallOfFame\Index.cshtml"
                   Write(Html.DisplayFor(modelItem => item.kills));

#line default
#line hidden
#nullable disable
            WriteLiteral("\r\n                    </td>\r\n                    <td>\r\n                        ");
#nullable restore
#line 42 "C:\Users\perez.kepa\KEPA\2EBAL\ERRONKA\Git hb\version\ERRONKA_3\c#\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\HallOfFame\Index.cshtml"
                   Write(Html.DisplayFor(modelItem => item.time));

#line default
#line hidden
#nullable disable
            WriteLiteral("\r\n                    </td>\r\n                    <td>\r\n                        ");
#nullable restore
#line 45 "C:\Users\perez.kepa\KEPA\2EBAL\ERRONKA\Git hb\version\ERRONKA_3\c#\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\HallOfFame\Index.cshtml"
                   Write(Html.DisplayFor(modelItem => item.date));

#line default
#line hidden
#nullable disable
            WriteLiteral("\r\n                    </td>\r\n                    <td>\r\n                        ");
#nullable restore
#line 48 "C:\Users\perez.kepa\KEPA\2EBAL\ERRONKA\Git hb\version\ERRONKA_3\c#\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\HallOfFame\Index.cshtml"
                   Write(Html.ActionLink("Edit", "Edit", new { /* id=item.PrimaryKey */ }));

#line default
#line hidden
#nullable disable
            WriteLiteral(" |\r\n                        ");
#nullable restore
#line 49 "C:\Users\perez.kepa\KEPA\2EBAL\ERRONKA\Git hb\version\ERRONKA_3\c#\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\HallOfFame\Index.cshtml"
                   Write(Html.ActionLink("Details", "Details", new { /* id=item.PrimaryKey */ }));

#line default
#line hidden
#nullable disable
            WriteLiteral(" |\r\n                        ");
#nullable restore
#line 50 "C:\Users\perez.kepa\KEPA\2EBAL\ERRONKA\Git hb\version\ERRONKA_3\c#\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\HallOfFame\Index.cshtml"
                   Write(Html.ActionLink("Delete", "Delete", new { /* id=item.PrimaryKey */ }));

#line default
#line hidden
#nullable disable
            WriteLiteral("\r\n                    </td>\r\n                </tr>\r\n");
#nullable restore
#line 53 "C:\Users\perez.kepa\KEPA\2EBAL\ERRONKA\Git hb\version\ERRONKA_3\c#\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\HallOfFame\Index.cshtml"
            }

#line default
#line hidden
#nullable disable
#nullable restore
#line 53 "C:\Users\perez.kepa\KEPA\2EBAL\ERRONKA\Git hb\version\ERRONKA_3\c#\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\HallOfFame\Index.cshtml"
             



        }
        else
        {
            

#line default
#line hidden
#nullable disable
#nullable restore
#line 60 "C:\Users\perez.kepa\KEPA\2EBAL\ERRONKA\Git hb\version\ERRONKA_3\c#\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\HallOfFame\Index.cshtml"
             for(int index=0; index < 10; index++)
            {

#line default
#line hidden
#nullable disable
            WriteLiteral("                <tr>\r\n                    <td>\r\n                        ");
#nullable restore
#line 64 "C:\Users\perez.kepa\KEPA\2EBAL\ERRONKA\Git hb\version\ERRONKA_3\c#\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\HallOfFame\Index.cshtml"
                   Write(Html.DisplayFor(modelItem => Model.partidak.OrderByDescending(a => a.puntuazioa).ElementAt(index).puntuazioa));

#line default
#line hidden
#nullable disable
            WriteLiteral("\r\n                    </td>\r\n                    <td>\r\n                        ");
#nullable restore
#line 67 "C:\Users\perez.kepa\KEPA\2EBAL\ERRONKA\Git hb\version\ERRONKA_3\c#\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\HallOfFame\Index.cshtml"
                   Write(Html.DisplayFor(modelItem => Model.partidak.OrderByDescending(a => a.puntuazioa).ElementAt(index).kills));

#line default
#line hidden
#nullable disable
            WriteLiteral("\r\n                    </td>\r\n                    <td>\r\n                        ");
#nullable restore
#line 70 "C:\Users\perez.kepa\KEPA\2EBAL\ERRONKA\Git hb\version\ERRONKA_3\c#\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\HallOfFame\Index.cshtml"
                   Write(Html.DisplayFor(modelItem => Model.partidak.OrderByDescending(a => a.puntuazioa).ElementAt(index).time));

#line default
#line hidden
#nullable disable
            WriteLiteral("\r\n                    </td>\r\n                    <td>\r\n                        ");
#nullable restore
#line 73 "C:\Users\perez.kepa\KEPA\2EBAL\ERRONKA\Git hb\version\ERRONKA_3\c#\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\HallOfFame\Index.cshtml"
                   Write(Html.DisplayFor(modelItem => Model.partidak.OrderByDescending(a => a.puntuazioa).ElementAt(index).date));

#line default
#line hidden
#nullable disable
            WriteLiteral("\r\n                    </td>\r\n                    <td>\r\n                        ");
#nullable restore
#line 76 "C:\Users\perez.kepa\KEPA\2EBAL\ERRONKA\Git hb\version\ERRONKA_3\c#\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\HallOfFame\Index.cshtml"
                   Write(Html.ActionLink("Edit", "Edit", new { /* id=item.PrimaryKey */ }));

#line default
#line hidden
#nullable disable
            WriteLiteral(" |\r\n                        ");
#nullable restore
#line 77 "C:\Users\perez.kepa\KEPA\2EBAL\ERRONKA\Git hb\version\ERRONKA_3\c#\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\HallOfFame\Index.cshtml"
                   Write(Html.ActionLink("Details", "Details", new { /* id=item.PrimaryKey */ }));

#line default
#line hidden
#nullable disable
            WriteLiteral(" |\r\n                        ");
#nullable restore
#line 78 "C:\Users\perez.kepa\KEPA\2EBAL\ERRONKA\Git hb\version\ERRONKA_3\c#\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\HallOfFame\Index.cshtml"
                   Write(Html.ActionLink("Delete", "Delete", new { /* id=item.PrimaryKey */ }));

#line default
#line hidden
#nullable disable
            WriteLiteral("\r\n                    </td>\r\n                </tr>\r\n");
#nullable restore
#line 81 "C:\Users\perez.kepa\KEPA\2EBAL\ERRONKA\Git hb\version\ERRONKA_3\c#\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\HallOfFame\Index.cshtml"
            }

#line default
#line hidden
#nullable disable
#nullable restore
#line 81 "C:\Users\perez.kepa\KEPA\2EBAL\ERRONKA\Git hb\version\ERRONKA_3\c#\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\HallOfFame\Index.cshtml"
             
        }

#line default
#line hidden
#nullable disable
            WriteLiteral("        ");
#nullable restore
#line 83 "C:\Users\perez.kepa\KEPA\2EBAL\ERRONKA\Git hb\version\ERRONKA_3\c#\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\HallOfFame\Index.cshtml"
   Write(await Component.InvokeAsync("Comments"));

#line default
#line hidden
#nullable disable
            WriteLiteral("\r\n    </tbody>\r\n</table>\r\n");
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