#pragma checksum "C:\Users\perez.kepa\KEPA\2EBAL\ERRONKA\Git hb\ERRONKA_3-29ff323144a7551cab490fbd391e44ab892dd20c\c#\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\Inkesta.cshtml" "{ff1816ec-aa5e-4d10-87f7-6f4963833460}" "a73fe28499a734064d92ed2b7821de467dfa25ab"
// <auto-generated/>
#pragma warning disable 1591
[assembly: global::Microsoft.AspNetCore.Razor.Hosting.RazorCompiledItemAttribute(typeof(AspNetCore.Views_Inkesta), @"mvc.1.0.view", @"/Views/Inkesta.cshtml")]
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
#line 1 "C:\Users\perez.kepa\KEPA\2EBAL\ERRONKA\Git hb\ERRONKA_3-29ff323144a7551cab490fbd391e44ab892dd20c\c#\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\_ViewImports.cshtml"
using GodRun_API_el_bueno_;

#line default
#line hidden
#nullable disable
#nullable restore
#line 2 "C:\Users\perez.kepa\KEPA\2EBAL\ERRONKA\Git hb\ERRONKA_3-29ff323144a7551cab490fbd391e44ab892dd20c\c#\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\_ViewImports.cshtml"
using GodRun_API_el_bueno_.Models;

#line default
#line hidden
#nullable disable
    [global::Microsoft.AspNetCore.Razor.Hosting.RazorSourceChecksumAttribute(@"SHA1", @"a73fe28499a734064d92ed2b7821de467dfa25ab", @"/Views/Inkesta.cshtml")]
    [global::Microsoft.AspNetCore.Razor.Hosting.RazorSourceChecksumAttribute(@"SHA1", @"eb050eb90757f832893d31f72cb29792359ca165", @"/Views/_ViewImports.cshtml")]
    public class Views_Inkesta : global::Microsoft.AspNetCore.Mvc.Razor.RazorPage<GodRun_API_el_bueno_.ViewModels.InkestaViewModel>
    {
        private static readonly global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute __tagHelperAttribute_0 = new global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute("asp-action", "Create", global::Microsoft.AspNetCore.Razor.TagHelpers.HtmlAttributeValueStyle.DoubleQuotes);
        private static readonly global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute __tagHelperAttribute_1 = new global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute("asp-action", "Edit", global::Microsoft.AspNetCore.Razor.TagHelpers.HtmlAttributeValueStyle.DoubleQuotes);
        private static readonly global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute __tagHelperAttribute_2 = new global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute("asp-action", "Details", global::Microsoft.AspNetCore.Razor.TagHelpers.HtmlAttributeValueStyle.DoubleQuotes);
        private static readonly global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute __tagHelperAttribute_3 = new global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute("asp-action", "Delete", global::Microsoft.AspNetCore.Razor.TagHelpers.HtmlAttributeValueStyle.DoubleQuotes);
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
            WriteLiteral("\n");
#nullable restore
#line 3 "C:\Users\perez.kepa\KEPA\2EBAL\ERRONKA\Git hb\ERRONKA_3-29ff323144a7551cab490fbd391e44ab892dd20c\c#\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\Inkesta.cshtml"
  
    ViewData["Title"] = "Inkesta";

#line default
#line hidden
#nullable disable
            WriteLiteral("\n<h1>Inkesta</h1>\n\n<p>\n    ");
            __tagHelperExecutionContext = __tagHelperScopeManager.Begin("a", global::Microsoft.AspNetCore.Razor.TagHelpers.TagMode.StartTagAndEndTag, "a73fe28499a734064d92ed2b7821de467dfa25ab4915", async() => {
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
                Would you recommend this experiece to anyone?
            </th>
            <th>
                Wich part was the most difficult?
            </th>
            <th>
                Was the boss challenging?
            </th>
            <th>
                Would you like an ESport show?
            </th>
            <th>
                Tell us your favourite item
            </th>
            <th>
                User
            </th>
            <th>
                Data
            </th>
            <th></th>
        </tr>
    </thead>
    <tbody>
");
#nullable restore
#line 40 "C:\Users\perez.kepa\KEPA\2EBAL\ERRONKA\Git hb\ERRONKA_3-29ff323144a7551cab490fbd391e44ab892dd20c\c#\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\Inkesta.cshtml"
 foreach (var item in Model.inkestak) {

#line default
#line hidden
#nullable disable
            WriteLiteral("        <tr>\n            <td>\n                ");
#nullable restore
#line 43 "C:\Users\perez.kepa\KEPA\2EBAL\ERRONKA\Git hb\ERRONKA_3-29ff323144a7551cab490fbd391e44ab892dd20c\c#\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\Inkesta.cshtml"
           Write(Html.DisplayFor(modelItem => item.Galdera1));

#line default
#line hidden
#nullable disable
            WriteLiteral("\n            </td>\n            <td>\n                ");
#nullable restore
#line 46 "C:\Users\perez.kepa\KEPA\2EBAL\ERRONKA\Git hb\ERRONKA_3-29ff323144a7551cab490fbd391e44ab892dd20c\c#\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\Inkesta.cshtml"
           Write(Html.DisplayFor(modelItem => item.Galdera2));

#line default
#line hidden
#nullable disable
            WriteLiteral("\n            </td>\n            <td>\n                ");
#nullable restore
#line 49 "C:\Users\perez.kepa\KEPA\2EBAL\ERRONKA\Git hb\ERRONKA_3-29ff323144a7551cab490fbd391e44ab892dd20c\c#\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\Inkesta.cshtml"
           Write(Html.DisplayFor(modelItem => item.Galdera3));

#line default
#line hidden
#nullable disable
            WriteLiteral("\n            </td>\n            <td>\n                ");
#nullable restore
#line 52 "C:\Users\perez.kepa\KEPA\2EBAL\ERRONKA\Git hb\ERRONKA_3-29ff323144a7551cab490fbd391e44ab892dd20c\c#\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\Inkesta.cshtml"
           Write(Html.DisplayFor(modelItem => item.Galdera4));

#line default
#line hidden
#nullable disable
            WriteLiteral("\n            </td>\n            <td>\n                ");
#nullable restore
#line 55 "C:\Users\perez.kepa\KEPA\2EBAL\ERRONKA\Git hb\ERRONKA_3-29ff323144a7551cab490fbd391e44ab892dd20c\c#\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\Inkesta.cshtml"
           Write(Html.DisplayFor(modelItem => item.Galdera5));

#line default
#line hidden
#nullable disable
            WriteLiteral("\n            </td>\n            <td>\n                ");
#nullable restore
#line 58 "C:\Users\perez.kepa\KEPA\2EBAL\ERRONKA\Git hb\ERRONKA_3-29ff323144a7551cab490fbd391e44ab892dd20c\c#\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\Inkesta.cshtml"
           Write(Html.DisplayFor(modelItem => item.Erabiltzailea));

#line default
#line hidden
#nullable disable
            WriteLiteral("\n            </td>\n            <td>\n                ");
#nullable restore
#line 61 "C:\Users\perez.kepa\KEPA\2EBAL\ERRONKA\Git hb\ERRONKA_3-29ff323144a7551cab490fbd391e44ab892dd20c\c#\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\Inkesta.cshtml"
           Write(Html.DisplayFor(modelItem => item.Data));

#line default
#line hidden
#nullable disable
            WriteLiteral("\n            </td>\n            <td>\n                ");
            __tagHelperExecutionContext = __tagHelperScopeManager.Begin("a", global::Microsoft.AspNetCore.Razor.TagHelpers.TagMode.StartTagAndEndTag, "a73fe28499a734064d92ed2b7821de467dfa25ab9841", async() => {
                WriteLiteral("Edit");
            }
            );
            __Microsoft_AspNetCore_Mvc_TagHelpers_AnchorTagHelper = CreateTagHelper<global::Microsoft.AspNetCore.Mvc.TagHelpers.AnchorTagHelper>();
            __tagHelperExecutionContext.Add(__Microsoft_AspNetCore_Mvc_TagHelpers_AnchorTagHelper);
            __Microsoft_AspNetCore_Mvc_TagHelpers_AnchorTagHelper.Action = (string)__tagHelperAttribute_1.Value;
            __tagHelperExecutionContext.AddTagHelperAttribute(__tagHelperAttribute_1);
            if (__Microsoft_AspNetCore_Mvc_TagHelpers_AnchorTagHelper.RouteValues == null)
            {
                throw new InvalidOperationException(InvalidTagHelperIndexerAssignment("asp-route-id", "Microsoft.AspNetCore.Mvc.TagHelpers.AnchorTagHelper", "RouteValues"));
            }
            BeginWriteTagHelperAttribute();
#nullable restore
#line 64 "C:\Users\perez.kepa\KEPA\2EBAL\ERRONKA\Git hb\ERRONKA_3-29ff323144a7551cab490fbd391e44ab892dd20c\c#\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\Inkesta.cshtml"
                                       WriteLiteral(item.id);

#line default
#line hidden
#nullable disable
            __tagHelperStringValueBuffer = EndWriteTagHelperAttribute();
            __Microsoft_AspNetCore_Mvc_TagHelpers_AnchorTagHelper.RouteValues["id"] = __tagHelperStringValueBuffer;
            __tagHelperExecutionContext.AddTagHelperAttribute("asp-route-id", __Microsoft_AspNetCore_Mvc_TagHelpers_AnchorTagHelper.RouteValues["id"], global::Microsoft.AspNetCore.Razor.TagHelpers.HtmlAttributeValueStyle.DoubleQuotes);
            await __tagHelperRunner.RunAsync(__tagHelperExecutionContext);
            if (!__tagHelperExecutionContext.Output.IsContentModified)
            {
                await __tagHelperExecutionContext.SetOutputContentAsync();
            }
            Write(__tagHelperExecutionContext.Output);
            __tagHelperExecutionContext = __tagHelperScopeManager.End();
            WriteLiteral(" |\n                ");
            __tagHelperExecutionContext = __tagHelperScopeManager.Begin("a", global::Microsoft.AspNetCore.Razor.TagHelpers.TagMode.StartTagAndEndTag, "a73fe28499a734064d92ed2b7821de467dfa25ab12087", async() => {
                WriteLiteral("Details");
            }
            );
            __Microsoft_AspNetCore_Mvc_TagHelpers_AnchorTagHelper = CreateTagHelper<global::Microsoft.AspNetCore.Mvc.TagHelpers.AnchorTagHelper>();
            __tagHelperExecutionContext.Add(__Microsoft_AspNetCore_Mvc_TagHelpers_AnchorTagHelper);
            __Microsoft_AspNetCore_Mvc_TagHelpers_AnchorTagHelper.Action = (string)__tagHelperAttribute_2.Value;
            __tagHelperExecutionContext.AddTagHelperAttribute(__tagHelperAttribute_2);
            if (__Microsoft_AspNetCore_Mvc_TagHelpers_AnchorTagHelper.RouteValues == null)
            {
                throw new InvalidOperationException(InvalidTagHelperIndexerAssignment("asp-route-id", "Microsoft.AspNetCore.Mvc.TagHelpers.AnchorTagHelper", "RouteValues"));
            }
            BeginWriteTagHelperAttribute();
#nullable restore
#line 65 "C:\Users\perez.kepa\KEPA\2EBAL\ERRONKA\Git hb\ERRONKA_3-29ff323144a7551cab490fbd391e44ab892dd20c\c#\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\Inkesta.cshtml"
                                          WriteLiteral(item.id);

#line default
#line hidden
#nullable disable
            __tagHelperStringValueBuffer = EndWriteTagHelperAttribute();
            __Microsoft_AspNetCore_Mvc_TagHelpers_AnchorTagHelper.RouteValues["id"] = __tagHelperStringValueBuffer;
            __tagHelperExecutionContext.AddTagHelperAttribute("asp-route-id", __Microsoft_AspNetCore_Mvc_TagHelpers_AnchorTagHelper.RouteValues["id"], global::Microsoft.AspNetCore.Razor.TagHelpers.HtmlAttributeValueStyle.DoubleQuotes);
            await __tagHelperRunner.RunAsync(__tagHelperExecutionContext);
            if (!__tagHelperExecutionContext.Output.IsContentModified)
            {
                await __tagHelperExecutionContext.SetOutputContentAsync();
            }
            Write(__tagHelperExecutionContext.Output);
            __tagHelperExecutionContext = __tagHelperScopeManager.End();
            WriteLiteral(" |\n                ");
            __tagHelperExecutionContext = __tagHelperScopeManager.Begin("a", global::Microsoft.AspNetCore.Razor.TagHelpers.TagMode.StartTagAndEndTag, "a73fe28499a734064d92ed2b7821de467dfa25ab14340", async() => {
                WriteLiteral("Delete");
            }
            );
            __Microsoft_AspNetCore_Mvc_TagHelpers_AnchorTagHelper = CreateTagHelper<global::Microsoft.AspNetCore.Mvc.TagHelpers.AnchorTagHelper>();
            __tagHelperExecutionContext.Add(__Microsoft_AspNetCore_Mvc_TagHelpers_AnchorTagHelper);
            __Microsoft_AspNetCore_Mvc_TagHelpers_AnchorTagHelper.Action = (string)__tagHelperAttribute_3.Value;
            __tagHelperExecutionContext.AddTagHelperAttribute(__tagHelperAttribute_3);
            if (__Microsoft_AspNetCore_Mvc_TagHelpers_AnchorTagHelper.RouteValues == null)
            {
                throw new InvalidOperationException(InvalidTagHelperIndexerAssignment("asp-route-id", "Microsoft.AspNetCore.Mvc.TagHelpers.AnchorTagHelper", "RouteValues"));
            }
            BeginWriteTagHelperAttribute();
#nullable restore
#line 66 "C:\Users\perez.kepa\KEPA\2EBAL\ERRONKA\Git hb\ERRONKA_3-29ff323144a7551cab490fbd391e44ab892dd20c\c#\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\Inkesta.cshtml"
                                         WriteLiteral(item.id);

#line default
#line hidden
#nullable disable
            __tagHelperStringValueBuffer = EndWriteTagHelperAttribute();
            __Microsoft_AspNetCore_Mvc_TagHelpers_AnchorTagHelper.RouteValues["id"] = __tagHelperStringValueBuffer;
            __tagHelperExecutionContext.AddTagHelperAttribute("asp-route-id", __Microsoft_AspNetCore_Mvc_TagHelpers_AnchorTagHelper.RouteValues["id"], global::Microsoft.AspNetCore.Razor.TagHelpers.HtmlAttributeValueStyle.DoubleQuotes);
            await __tagHelperRunner.RunAsync(__tagHelperExecutionContext);
            if (!__tagHelperExecutionContext.Output.IsContentModified)
            {
                await __tagHelperExecutionContext.SetOutputContentAsync();
            }
            Write(__tagHelperExecutionContext.Output);
            __tagHelperExecutionContext = __tagHelperScopeManager.End();
            WriteLiteral("\n            </td>\n        </tr>\n");
#nullable restore
#line 69 "C:\Users\perez.kepa\KEPA\2EBAL\ERRONKA\Git hb\ERRONKA_3-29ff323144a7551cab490fbd391e44ab892dd20c\c#\GodRun_API(el bueno)\GodRun_API(el bueno)\Views\Inkesta.cshtml"
}

#line default
#line hidden
#nullable disable
            WriteLiteral("    </tbody>\n</table>\n");
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
        public global::Microsoft.AspNetCore.Mvc.Rendering.IHtmlHelper<GodRun_API_el_bueno_.ViewModels.InkestaViewModel> Html { get; private set; }
    }
}
#pragma warning restore 1591
