(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-a2d3823e"],{"7cd5":function(t,e,n){"use strict";n.r(e);var r=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("v-container",{attrs:{"grid-list-xl":""}},[n("v-layout",{attrs:{row:"",wrap:""}},t._l(t.tours,(function(e,r){return n("v-flex",{key:r,attrs:{xs12:"",sm4:""}},[n("v-card",[n("v-card-title",[t._v(" "+t._s(e.title)+" ")]),n("v-card-text",[t._v(" "+t._s(e.addr1)+" ")])],1)],1)})),1)],1)},a=[],c={data:function(){return{tours:[]}},methods:{retrieveUsers:function(){var t=this;this.$axios.get("/apitest").then((function(e){t.tours=e.data,console.log(e.data)})).catch((function(t){console.log(t)}))}},mounted:function(){this.retrieveUsers()}},o=c,u=n("2877"),i=n("6544"),s=n.n(i),d=n("b0af"),l=n("99d9"),f=n("a523"),v=(n("20f6"),n("e8f2")),_=Object(v["a"])("flex"),b=Object(v["a"])("layout"),x=Object(u["a"])(o,r,a,!1,null,null,null);e["default"]=x.exports;s()(x,{VCard:d["a"],VCardText:l["c"],VCardTitle:l["d"],VContainer:f["a"],VFlex:_,VLayout:b})},"99d9":function(t,e,n){"use strict";n.d(e,"a",(function(){return c})),n.d(e,"b",(function(){return o})),n.d(e,"c",(function(){return u})),n.d(e,"d",(function(){return i}));var r=n("b0af"),a=n("80d2"),c=Object(a["e"])("v-card__actions"),o=Object(a["e"])("v-card__subtitle"),u=Object(a["e"])("v-card__text"),i=Object(a["e"])("v-card__title");r["a"]}}]);
//# sourceMappingURL=chunk-a2d3823e.eaa06c33.js.map