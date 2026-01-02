parser grammar HTMLParser;

options { tokenVocab=HTMLLexer; }

document: (doctype | element | comment)* EOF;

doctype: DOCTYPE_OPEN .*? TAG_CLOSE;

element: normal_tag | self_closing_tag | script_tag | style_tag | text;

normal_tag: TAG_OPEN TAG_NAME attribute* TAG_CLOSE content TAG_END_OPEN TAG_NAME TAG_CLOSE;

self_closing_tag: TAG_OPEN TAG_NAME attribute* SLASH_CLOSE;

script_tag: SCRIPT_OPEN attribute* TAG_CLOSE .*? TAG_END_OPEN SCRIPT TAG_CLOSE;

style_tag: STYLE_OPEN attribute* TAG_CLOSE .*? TAG_END_OPEN STYLE TAG_CLOSE;

content: (element | text | HTML_COMMENT)*;

text: TEXT;

attribute: ATTRIBUTE_NAME (EQUALS STRING)?;

comment: HTML_COMMENT;