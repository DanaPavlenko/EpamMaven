<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="1.0">
    <xsl:template match="/">
    <!--  to finish this task-->
        <html>
            <head>
                <style type="text/css">
                    table.gems {
                    border: 1px ;
                    }

                    td.colfmt {
                    border: 1px ;
                    background-color: yellow;
                    color: red;
                    text-align:right;
                    }

                    th {
                    background-color: #2E9AFE;
                    color: white;
                    }

                </style>
            </head>

            <body>
                <table class="gems">
                    <tr>
                        <th style="width:250px">Name</th>
                        <th style="width:350px">Preciousness</th>
                        <th style="width:250px">Origin</th>
                        <th style="width:250px">Color</th>
                        <th style="width:250px">Transparency</th>
                        <th style="width:250px">Edges</th>
                        <th style="width:250px">Value</th>

                    </tr>

                    <xsl:for-each select="gems/gem">

                        <tr>
                            <td class="colfmt">
                                <xsl:value-of select="@gemNo"/>
                            </td>

                            <td class="colfmt">
                                <xsl:value-of select="name" />
                            </td>
                            <td class="colfmt">
                                <xsl:value-of select="preciousness" />
                            </td>

                            <td class="colfmt">
                                <xsl:value-of select="origin"/>
                            </td>
                            <td class="colfmt">
                                <xsl:value-of select="color"/>
                            </td>

                            <td class="colfmt">
                                <xsl:value-of select="edge_number"/>
                            </td>

                            <td class="colfmt">
                                <xsl:value-of select="value"/>
                            </td>
                        </tr>

                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>