<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="project-tag" uri="/WEB-INF/tags.tld" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${cookie['lang'].value}"/>
<fmt:setBundle basename="content"/>

<html lang="${cookie['lang'].value}">
<head>
    <title>Loan</title>
    <link rel="stylesheet" href="static/css/loan.css">
</head>
<body>
<div id="container" class="container-bordered">
    <div class="_3eutj">
        <div class="gccS5 _134VX _1HYOs _2e46x _1-XW8 aWyZw _3yd9c dC2g2 _1QHM4 _3G1UV _3Ez5X zMBct _3BBI-">
            <div class="_2HTCX">
                <table class="_2F5n_ IDj1O _22xg_ _3cDEk tYkrp">
                    <thead>
                    <tr>
                        <th class="_1yyno">Lender</th>
                        <th>NerdWallet<!-- --> <span class="_2ocku">Rating <span
                                aria-describedby="rating-tooltip" class="_3wPWP"><svg
                                viewBox="0 0 24 24" fill="currentcolor" focusable="false"
                                class="_2MUBf _2ulGk"><path
                                d="M12 15.387c-.645 0-1.129.524-1.129 1.13 0 .644.484 1.128 1.129 1.128.605 0 1.129-.484 1.129-1.129 0-.605-.524-1.129-1.129-1.129zm.282-.968a.466.466 0 00.484-.484c0-1.733 3.145-1.612 3.145-4.314 0-2.056-1.854-3.266-3.951-3.266-1.815 0-2.823.726-3.67 1.814-.161.242-.12.525.121.686l.524.403c.202.121.484.08.646-.12.604-.767 1.21-1.17 2.379-1.17 1.613 0 2.338.847 2.338 1.653 0 1.734-3.145 1.492-3.145 4.314a.49.49 0 00.484.484h.645zM12 3.29c4.758 0 8.71 3.912 8.71 8.71A8.7 8.7 0 0112 20.71 8.673 8.673 0 013.29 12 8.699 8.699 0 0112 3.29zM12 2C6.476 2 2 6.516 2 12c0 5.524 4.476 10 10 10 5.484 0 10-4.476 10-10 0-5.484-4.516-10-10-10z"></path></svg></span></span>
                        </th>
                        <th>Est. APR</th>
                        <th>Min. Credit Score</th>
                        <th class="_2XJHT">Learn More</th>
                    </tr>
                    </thead>
                    <tbody>
                    </tr>
                    <tr>
                        <td class="_1yyno">
                            <div>
                                <div>
                                    <a id="universal-product-summary-table__product-image--2"
                                       rel="nofollow"
                                       href="https://www.nerdwallet.com/redirect/eed9766a-233a-11e8-9c02-ffe1366b5f65?category=Personal%20Loans%20Offers&amp;trk_channel=web&amp;trk_element=image&amp;trk_location=MarketplaceApplyNow&amp;trk_nldt=undefined&amp;trk_pagetype=roundup&amp;trk_sectionCategory=ProductSummaryTable__productImage&amp;trk_topic=Personal%20Loans&amp;trk_vertical=Loans&amp;finish_type=external_application_referral&amp;has_prequalified=false&amp;impression_id=&amp;link_type=PRODUCT_IMAGE&amp;monetizable=&amp;page_number=&amp;product_display_driver=&amp;product_position=2&amp;section_name=&amp;section_position=&amp;header_pageViewId="
                                       target="_blank">
                                        <figure class="gccS5 _5c4iG _3b9sz">
                                            <div class="_2N0Qs"
                                                 style="background-color:rgba(255,255,255,0)">
                                                <div class="_11bDt _3SEyh -cQed">
                                                    <picture><img
                                                            alt="Marcus by Goldman Sachs"
                                                            class="_2dowB pmdQr _3SEyh TrqDa"
                                                            src="https://www.nerdwallet.com/cdn/loans/pl/MarcusbygoldmansachsLogo.svg"
                                                            style="object-fit:contain"/>
                                                    </picture>
                                                </div>
                                            </div>
                                        </figure>
                                    </a></div>
                                <p class="_1nuia">Marcus by Goldman Sachs</p>
                                <div class="lSL4a">
                                    <div class="apply-now">
                                        <div><a class="_3SEyh _30MBE _31zBK qjkre VFnHN"
                                                id="universal-product-summary-table__product-button--2"
                                                href="https://www.nerdwallet.com/redirect/eed9766a-233a-11e8-9c02-ffe1366b5f65?category=Personal%20Loans%20Offers&amp;trk_channel=web&amp;trk_element=button&amp;trk_location=MarketplaceApplyNow&amp;trk_nldt=undefined&amp;trk_pagetype=roundup&amp;trk_sectionCategory=ProductSummaryTable__cta&amp;trk_topic=Personal%20Loans&amp;trk_vertical=Loans&amp;finish_type=external_application_referral&amp;has_prequalified=false&amp;impression_id=&amp;link_type=APPLY_NOW_BUTTON&amp;monetizable=&amp;page_number=&amp;product_display_driver=&amp;product_position=2&amp;section_name=&amp;section_position=&amp;header_pageViewId="
                                                target="_blank">
                                            <div class="_2r4JO">
                                                <div class="_2v2FF _1eCRG">
                                                    <div class="_3jS8m"><span class="nBbS3">Check Rate</span>
                                                    </div>
                                                </div>
                                            </div>
                                        </a></div>
                                        <p class="annotation _3uLFr _30MBE _27QNm _22U5z">on
                                            Goldman Sachs&#x27;s website</p></div>
                                </div>
                            </div>
                        </td>
                        <td>
                            <div class="_3rMmf _2TgzK"><a class="L5G7w"
                                                          href="https://www.nerdwallet.com/reviews/loans/personal-loans/marcus-personal-loans?trk_channel=web&amp;trk_element=hyperlink&amp;trk_location=ProductSummaryTable-rating-link&amp;trk_nldt=undefined&amp;trk_pagetype=roundup&amp;trk_topic=Personal%20Loans&amp;trk_vertical=Loans">
                                <svg viewBox="0 0 14 14" version="1.1"
                                     xmlns="http://www.w3.org/2000/svg" class="_1TR9s">
                                    <defs>
                                        <filter id="outline_selected">
                                            <feFlood flood-color="#00aacc"
                                                     result="base"></feFlood>
                                            <feMorphology result="bigger" in="SourceGraphic"
                                                          operator="dilate"
                                                          radius="1"></feMorphology>
                                            <feColorMatrix result="mask" in="bigger"
                                                           type="matrix"
                                                           values="0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0"></feColorMatrix>
                                            <feComposite result="drop" in="base" in2="mask"
                                                         operator="in"></feComposite>
                                            <feGaussianBlur result="blur" in="drop"
                                                            stdDeviation="1"></feGaussianBlur>
                                            <feBlend in="SourceGraphic" in2="blur"
                                                     mode="normal"></feBlend>
                                        </filter>
                                    </defs>
                                    <g stroke="none" stroke-width="1" fill-rule="evenodd">
                                        <polygon fill="#64666A"
                                                 transform="translate(3.501500, 6.650000) translate(-3.501500, -6.650000) "
                                                 points="6.996 0 5.03 4.63725674 0 5.0730929 3.813 8.38284867 2.674 13.3000002 7.001 10.6979784 7.003 10.6999776"></polygon>
                                        <polygon fill="#64666A"
                                                 transform="translate(10.470000, 6.650000) scale(-1, 1) translate(-10.490000, -6.650000)"
                                                 points="13.9830028 -1.0658141e-14 12.017845 4.63725674 6.98999977 5.0730929 10.8013663 8.38284867 9.66285426 13.3000002 13.9880006 10.6979784 13.9899998 10.6999776"></polygon>
                                    </g>
                                </svg>
                                <p class="_26Nf4 Uk7cV">5.0</p><span
                                    class="_1jytb _1nuia _22U5z">/5</span></a></div>
                            <p class="_3uLFr _1nuia _22U5z">Best for: <!-- -->Bank loans for
                                flexible payments, rate discounts</p></td>
                        <td class="_3Zx3Y"><p class="_1hL7v">6.99 - 19.99%</p></td>
                        <td class="_3Zx3Y">
                            <p class="_1hL7v">660<span aria-describedby="minCreditScore"
                                                       class="_3Gte1 _3wPWP"><svg
                                    viewBox="0 0 24 24" fill="currentcolor"
                                    focusable="false" class="_2MUBf _2ulGk"><path
                                    d="M12 15.387c-.645 0-1.129.524-1.129 1.13 0 .644.484 1.128 1.129 1.128.605 0 1.129-.484 1.129-1.129 0-.605-.524-1.129-1.129-1.129zm.282-.968a.466.466 0 00.484-.484c0-1.733 3.145-1.612 3.145-4.314 0-2.056-1.854-3.266-3.951-3.266-1.815 0-2.823.726-3.67 1.814-.161.242-.12.525.121.686l.524.403c.202.121.484.08.646-.12.604-.767 1.21-1.17 2.379-1.17 1.613 0 2.338.847 2.338 1.653 0 1.734-3.145 1.492-3.145 4.314a.49.49 0 00.484.484h.645zM12 3.29c4.758 0 8.71 3.912 8.71 8.71A8.7 8.7 0 0112 20.71 8.673 8.673 0 013.29 12 8.699 8.699 0 0112 3.29zM12 2C6.476 2 2 6.516 2 12c0 5.524 4.476 10 10 10 5.484 0 10-4.476 10-10 0-5.484-4.516-10-10-10z"></path></svg></span>
                            </p>
                        </td>
                        <td class="_2XJHT">
                            <div class="apply-now">
                                <div><a class="_3SEyh _30MBE _31zBK qjkre _2v2FF _1eCRG"
                                        id="universal-product-summary-table__product-button--2"
                                        href="https://www.nerdwallet.com/redirect/eed9766a-233a-11e8-9c02-ffe1366b5f65?category=Personal%20Loans%20Offers&amp;trk_channel=web&amp;trk_element=button&amp;trk_location=MarketplaceApplyNow&amp;trk_nldt=undefined&amp;trk_pagetype=roundup&amp;trk_sectionCategory=ProductSummaryTable__cta&amp;trk_topic=Personal%20Loans&amp;trk_vertical=Loans&amp;finish_type=external_application_referral&amp;has_prequalified=false&amp;impression_id=&amp;link_type=APPLY_NOW_BUTTON&amp;monetizable=&amp;page_number=&amp;product_display_driver=&amp;product_position=2&amp;section_name=&amp;section_position=&amp;header_pageViewId="
                                        target="_blank">
                                    <div class="_3jS8m"><span
                                            class="nBbS3">Check Rate</span></div>
                                </a></div>
                                <p class="annotation _3uLFr _30MBE _27QNm _22U5z">on Goldman
                                    Sachs&#x27;s website</p></div>
                        </td>
                    </tr>
                    <tr>
                        <td class="_1yyno">
                            <div><a class="_2EF16 undefined _1DyAk"
                                    href="https://www.nerdwallet.com/personal-loans/pre-qualify/step-1?trk_channel=web&amp;trk_element=hyperlink&amp;trk_location=ProductSummaryTable-MarketplaceApplyNow-MarketplaceReviewLink&amp;trk_nldt=undefined&amp;trk_pagetype=roundup&amp;trk_sectionCategory=ProductSummaryTable__productImage&amp;trk_topic=Personal%20Loans&amp;trk_vertical=Loans">
                                <figure class="gccS5 _5c4iG _3b9sz">
                                    <div class="_2N0Qs"
                                         style="background-color:rgba(255,255,255,0)">
                                        <div class="_11bDt _3SEyh -cQed">
                                            <picture><img alt="PNC Bank Personal Loan"
                                                          class="_2dowB pmdQr _3SEyh TrqDa"
                                                          src="https://www.nerdwallet.com/cdn/loans/pl/PNC.jpg"
                                                          style="object-fit:contain"/>
                                            </picture>
                                        </div>
                                    </div>
                                </figure>
                            </a>
                                <p class="_1nuia">PNC Bank Personal Loan</p>
                                <div class="lSL4a"><a class="_3SEyh _31zBK qjkre VFnHN"
                                                      href="https://www.nerdwallet.com/personal-loans/pre-qualify/step-1?trk_channel=web&amp;trk_element=button&amp;trk_location=ProductSummaryTable-MarketplaceApplyNow-MarketplaceReviewLink&amp;trk_nldt=undefined&amp;trk_pagetype=roundup&amp;trk_sectionCategory=ProductSummaryTable__cta&amp;trk_topic=Personal%20Loans&amp;trk_vertical=Loans">
                                    <div class="_2r4JO">
                                        <div class="_2v2FF _1eCRG">
                                            <div class="_3jS8m">See my rates</div>
                                        </div>
                                    </div>
                                </a>
                                    <p class="_3uLFr _30MBE _1nuia _22U5z">on NerdWallet&#x27;s
                                        secure website</p></div>
                            </div>
                        </td>
                        <td>
                            <div class="_3rMmf _2TgzK"><a class="L5G7w"
                                                          href="https://www.nerdwallet.com/blog/loans/pnc-personal-loans-review/?trk_channel=web&amp;trk_element=hyperlink&amp;trk_location=ProductSummaryTable-rating-link&amp;trk_nldt=undefined&amp;trk_pagetype=roundup&amp;trk_topic=Personal%20Loans&amp;trk_vertical=Loans">
                                <svg viewBox="0 0 14 14" version="1.1"
                                     xmlns="http://www.w3.org/2000/svg" class="_1TR9s">
                                    <defs>
                                        <filter id="outline_selected">
                                            <feFlood flood-color="#00aacc"
                                                     result="base"></feFlood>
                                            <feMorphology result="bigger" in="SourceGraphic"
                                                          operator="dilate"
                                                          radius="1"></feMorphology>
                                            <feColorMatrix result="mask" in="bigger"
                                                           type="matrix"
                                                           values="0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0"></feColorMatrix>
                                            <feComposite result="drop" in="base" in2="mask"
                                                         operator="in"></feComposite>
                                            <feGaussianBlur result="blur" in="drop"
                                                            stdDeviation="1"></feGaussianBlur>
                                            <feBlend in="SourceGraphic" in2="blur"
                                                     mode="normal"></feBlend>
                                        </filter>
                                    </defs>
                                    <g stroke="none" stroke-width="1" fill-rule="evenodd">
                                        <polygon fill="#64666A"
                                                 transform="translate(3.501500, 6.650000) translate(-3.501500, -6.650000) "
                                                 points="6.996 0 5.03 4.63725674 0 5.0730929 3.813 8.38284867 2.674 13.3000002 7.001 10.6979784 7.003 10.6999776"></polygon>
                                        <polygon fill="#64666A"
                                                 transform="translate(10.470000, 6.650000) scale(-1, 1) translate(-10.490000, -6.650000)"
                                                 points="13.9830028 -1.0658141e-14 12.017845 4.63725674 6.98999977 5.0730929 10.8013663 8.38284867 9.66285426 13.3000002 13.9880006 10.6979784 13.9899998 10.6999776"></polygon>
                                    </g>
                                </svg>
                                <p class="_26Nf4 Uk7cV">4.5</p><span
                                    class="_1jytb _1nuia _22U5z">/5</span></a></div>
                            <p class="_3uLFr _1nuia _22U5z">Best for: <!-- -->Bank loans for
                                flexible payments, rate discounts</p></td>
                        <td class="_3Zx3Y"><p class="_1hL7v">7.49 - 22.49%</p></td>
                        <td class="_3Zx3Y"><p class="_1hL7v">None</p></td>
                        <td class="_2XJHT"><a class="_3SEyh _31zBK qjkre _2v2FF _1eCRG"
                                              href="https://www.nerdwallet.com/personal-loans/pre-qualify/step-1?trk_channel=web&amp;trk_element=button&amp;trk_location=ProductSummaryTable-MarketplaceApplyNow-MarketplaceReviewLink&amp;trk_nldt=undefined&amp;trk_pagetype=roundup&amp;trk_sectionCategory=ProductSummaryTable__cta&amp;trk_topic=Personal%20Loans&amp;trk_vertical=Loans">
                            <div class="_3jS8m">See my rates</div>
                        </a>
                            <p class="_3uLFr _30MBE _1nuia _22U5z">on NerdWallet&#x27;s
                                secure website</p></td>
                    </tr>
                    <tr>
                        <td class="_1yyno">
                            <div><a class="_2EF16 undefined _1DyAk"
                                    href="https://www.nerdwallet.com/personal-loans/pre-qualify/step-1?trk_channel=web&amp;trk_element=hyperlink&amp;trk_location=ProductSummaryTable-MarketplaceApplyNow-MarketplaceReviewLink&amp;trk_nldt=undefined&amp;trk_pagetype=roundup&amp;trk_sectionCategory=ProductSummaryTable__productImage&amp;trk_topic=Personal%20Loans&amp;trk_vertical=Loans">
                                <figure class="gccS5 _5c4iG _3b9sz">
                                    <div class="_2N0Qs"
                                         style="background-color:rgba(255,255,255,0)">
                                        <div class="_11bDt _3SEyh -cQed">
                                            <picture><img alt="HSBC Personal Loan"
                                                          class="_2dowB pmdQr _3SEyh TrqDa"
                                                          src="https://www.nerdwallet.com/cdn/loans/pl/hsbc.jpeg"
                                                          style="object-fit:contain"/>
                                            </picture>
                                        </div>
                                    </div>
                                </figure>
                            </a>
                                <p class="_1nuia">HSBC Personal Loan</p>
                                <div class="lSL4a"><a class="_3SEyh _31zBK qjkre VFnHN"
                                                      href="https://www.nerdwallet.com/personal-loans/pre-qualify/step-1?trk_channel=web&amp;trk_element=button&amp;trk_location=ProductSummaryTable-MarketplaceApplyNow-MarketplaceReviewLink&amp;trk_nldt=undefined&amp;trk_pagetype=roundup&amp;trk_sectionCategory=ProductSummaryTable__cta&amp;trk_topic=Personal%20Loans&amp;trk_vertical=Loans">
                                    <div class="_2r4JO">
                                        <div class="_2v2FF _1eCRG">
                                            <div class="_3jS8m">See my rates</div>
                                        </div>
                                    </div>
                                </a>
                                    <p class="_3uLFr _30MBE _1nuia _22U5z">on NerdWallet&#x27;s
                                        secure website</p></div>
                            </div>
                        </td>
                        <td>
                            <div class="_3rMmf _2TgzK"><a class="L5G7w"
                                                          href="https://www.nerdwallet.com/reviews/loans/personal-loans/hsbc-personal-loan?trk_channel=web&amp;trk_element=hyperlink&amp;trk_location=ProductSummaryTable-rating-link&amp;trk_nldt=undefined&amp;trk_pagetype=roundup&amp;trk_topic=Personal%20Loans&amp;trk_vertical=Loans">
                                <svg viewBox="0 0 14 14" version="1.1"
                                     xmlns="http://www.w3.org/2000/svg" class="_1TR9s">
                                    <defs>
                                        <filter id="outline_selected">
                                            <feFlood flood-color="#00aacc"
                                                     result="base"></feFlood>
                                            <feMorphology result="bigger" in="SourceGraphic"
                                                          operator="dilate"
                                                          radius="1"></feMorphology>
                                            <feColorMatrix result="mask" in="bigger"
                                                           type="matrix"
                                                           values="0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0"></feColorMatrix>
                                            <feComposite result="drop" in="base" in2="mask"
                                                         operator="in"></feComposite>
                                            <feGaussianBlur result="blur" in="drop"
                                                            stdDeviation="1"></feGaussianBlur>
                                            <feBlend in="SourceGraphic" in2="blur"
                                                     mode="normal"></feBlend>
                                        </filter>
                                    </defs>
                                    <g stroke="none" stroke-width="1" fill-rule="evenodd">
                                        <polygon fill="#64666A"
                                                 transform="translate(3.501500, 6.650000) translate(-3.501500, -6.650000) "
                                                 points="6.996 0 5.03 4.63725674 0 5.0730929 3.813 8.38284867 2.674 13.3000002 7.001 10.6979784 7.003 10.6999776"></polygon>
                                        <polygon fill="#64666A"
                                                 transform="translate(10.470000, 6.650000) scale(-1, 1) translate(-10.490000, -6.650000)"
                                                 points="13.9830028 -1.0658141e-14 12.017845 4.63725674 6.98999977 5.0730929 10.8013663 8.38284867 9.66285426 13.3000002 13.9880006 10.6979784 13.9899998 10.6999776"></polygon>
                                    </g>
                                </svg>
                                <p class="_26Nf4 Uk7cV">4.0</p><span
                                    class="_1jytb _1nuia _22U5z">/5</span></a></div>
                            <p class="_3uLFr _1nuia _22U5z">Best for: <!-- -->Bank loans for
                                flexible payments, rate discounts</p></td>
                        <td class="_3Zx3Y"><p class="_1hL7v">6.99 - 22.90%</p></td>
                        <td class="_3Zx3Y"><p class="_1hL7v">700</p></td>
                        <td class="_2XJHT"><a class="_3SEyh _31zBK qjkre _2v2FF _1eCRG"
                                              href="https://www.nerdwallet.com/personal-loans/pre-qualify/step-1?trk_channel=web&amp;trk_element=button&amp;trk_location=ProductSummaryTable-MarketplaceApplyNow-MarketplaceReviewLink&amp;trk_nldt=undefined&amp;trk_pagetype=roundup&amp;trk_sectionCategory=ProductSummaryTable__cta&amp;trk_topic=Personal%20Loans&amp;trk_vertical=Loans">
                            <div class="_3jS8m">See my rates</div>
                        </a>
                            <p class="_3uLFr _30MBE _1nuia _22U5z">on NerdWallet&#x27;s
                                secure website</p></td>
                    </tr>
                    <tr>
                        <td class="_1yyno">
                            <div><a class="_2EF16 undefined _1DyAk"
                                    href="https://www.nerdwallet.com/personal-loans/pre-qualify/step-1?trk_channel=web&amp;trk_element=hyperlink&amp;trk_location=ProductSummaryTable-MarketplaceApplyNow-MarketplaceReviewLink&amp;trk_nldt=undefined&amp;trk_pagetype=roundup&amp;trk_sectionCategory=ProductSummaryTable__productImage&amp;trk_topic=Personal%20Loans&amp;trk_vertical=Loans">
                                <figure class="gccS5 _5c4iG _3b9sz">
                                    <div class="_2N0Qs"
                                         style="background-color:rgba(255,255,255,0)">
                                        <div class="_11bDt _3SEyh -cQed">
                                            <picture><img alt="Wells Fargo Personal Loan"
                                                          class="_2dowB pmdQr _3SEyh TrqDa"
                                                          src="https://www.nerdwallet.com/cdn/loans/pl/wells_logo.jpg"
                                                          style="object-fit:contain"/>
                                            </picture>
                                        </div>
                                    </div>
                                </figure>
                            </a>
                                <p class="_1nuia">Wells Fargo Personal Loan</p>
                                <div class="lSL4a"><a class="_3SEyh _31zBK qjkre VFnHN"
                                                      href="https://www.nerdwallet.com/personal-loans/pre-qualify/step-1?trk_channel=web&amp;trk_element=button&amp;trk_location=ProductSummaryTable-MarketplaceApplyNow-MarketplaceReviewLink&amp;trk_nldt=undefined&amp;trk_pagetype=roundup&amp;trk_sectionCategory=ProductSummaryTable__cta&amp;trk_topic=Personal%20Loans&amp;trk_vertical=Loans">
                                    <div class="_2r4JO">
                                        <div class="_2v2FF _1eCRG">
                                            <div class="_3jS8m">See my rates</div>
                                        </div>
                                    </div>
                                </a>
                                    <p class="_3uLFr _30MBE _1nuia _22U5z">on NerdWallet&#x27;s
                                        secure website</p></div>
                            </div>
                        </td>
                        <td>
                            <div class="_3rMmf _2TgzK"><a class="L5G7w"
                                                          href="https://www.nerdwallet.com/blog/loans/wells-fargo-personal-loans/?trk_channel=web&amp;trk_element=hyperlink&amp;trk_location=ProductSummaryTable-rating-link&amp;trk_nldt=undefined&amp;trk_pagetype=roundup&amp;trk_topic=Personal%20Loans&amp;trk_vertical=Loans">
                                <svg viewBox="0 0 14 14" version="1.1"
                                     xmlns="http://www.w3.org/2000/svg" class="_1TR9s">
                                    <defs>
                                        <filter id="outline_selected">
                                            <feFlood flood-color="#00aacc"
                                                     result="base"></feFlood>
                                            <feMorphology result="bigger" in="SourceGraphic"
                                                          operator="dilate"
                                                          radius="1"></feMorphology>
                                            <feColorMatrix result="mask" in="bigger"
                                                           type="matrix"
                                                           values="0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0"></feColorMatrix>
                                            <feComposite result="drop" in="base" in2="mask"
                                                         operator="in"></feComposite>
                                            <feGaussianBlur result="blur" in="drop"
                                                            stdDeviation="1"></feGaussianBlur>
                                            <feBlend in="SourceGraphic" in2="blur"
                                                     mode="normal"></feBlend>
                                        </filter>
                                    </defs>
                                    <g stroke="none" stroke-width="1" fill-rule="evenodd">
                                        <polygon fill="#64666A"
                                                 transform="translate(3.501500, 6.650000) translate(-3.501500, -6.650000) "
                                                 points="6.996 0 5.03 4.63725674 0 5.0730929 3.813 8.38284867 2.674 13.3000002 7.001 10.6979784 7.003 10.6999776"></polygon>
                                        <polygon fill="#64666A"
                                                 transform="translate(10.470000, 6.650000) scale(-1, 1) translate(-10.490000, -6.650000)"
                                                 points="13.9830028 -1.0658141e-14 12.017845 4.63725674 6.98999977 5.0730929 10.8013663 8.38284867 9.66285426 13.3000002 13.9880006 10.6979784 13.9899998 10.6999776"></polygon>
                                    </g>
                                </svg>
                                <p class="_26Nf4 Uk7cV">4.0</p><span
                                    class="_1jytb _1nuia _22U5z">/5</span></a></div>
                            <p class="_3uLFr _1nuia _22U5z">Best for: <!-- -->Bank loans for
                                home improvement</p></td>
                        <td class="_3Zx3Y"><p class="_1hL7v">5.49 - 24.49%</p></td>
                        <td class="_3Zx3Y"><p class="_1hL7v">600</p></td>
                        <td class="_2XJHT"><a class="_3SEyh _31zBK qjkre _2v2FF _1eCRG"
                                              href="https://www.nerdwallet.com/personal-loans/pre-qualify/step-1?trk_channel=web&amp;trk_element=button&amp;trk_location=ProductSummaryTable-MarketplaceApplyNow-MarketplaceReviewLink&amp;trk_nldt=undefined&amp;trk_pagetype=roundup&amp;trk_sectionCategory=ProductSummaryTable__cta&amp;trk_topic=Personal%20Loans&amp;trk_vertical=Loans">
                            <div class="_3jS8m">See my rates</div>
                        </a>
                            <p class="_3uLFr _30MBE _1nuia _22U5z">on NerdWallet&#x27;s
                                secure website</p></td>
                    </tr>
                    <tr>
                        <td class="_1yyno">
                            <div><a class="_2EF16 undefined _1DyAk"
                                    href="https://www.nerdwallet.com/personal-loans/pre-qualify/step-1?trk_channel=web&amp;trk_element=hyperlink&amp;trk_location=ProductSummaryTable-MarketplaceApplyNow-MarketplaceReviewLink&amp;trk_nldt=undefined&amp;trk_pagetype=roundup&amp;trk_sectionCategory=ProductSummaryTable__productImage&amp;trk_topic=Personal%20Loans&amp;trk_vertical=Loans">
                                <figure class="gccS5 _5c4iG _3b9sz">
                                    <div class="_2N0Qs"
                                         style="background-color:rgba(255,255,255,0)">
                                        <div class="_11bDt _3SEyh -cQed">
                                            <picture><img alt="Citibank"
                                                          class="_2dowB pmdQr _3SEyh TrqDa"
                                                          src="https://www.nerdwallet.com/cdn/loans/pl/citibank.jpg"
                                                          style="object-fit:contain"/>
                                            </picture>
                                        </div>
                                    </div>
                                </figure>
                            </a>
                                <p class="_1nuia">Citibank</p>
                                <div class="lSL4a"><a class="_3SEyh _31zBK qjkre VFnHN"
                                                      href="https://www.nerdwallet.com/personal-loans/pre-qualify/step-1?trk_channel=web&amp;trk_element=button&amp;trk_location=ProductSummaryTable-MarketplaceApplyNow-MarketplaceReviewLink&amp;trk_nldt=undefined&amp;trk_pagetype=roundup&amp;trk_sectionCategory=ProductSummaryTable__cta&amp;trk_topic=Personal%20Loans&amp;trk_vertical=Loans">
                                    <div class="_2r4JO">
                                        <div class="_2v2FF _1eCRG">
                                            <div class="_3jS8m">See my rates</div>
                                        </div>
                                    </div>
                                </a>
                                    <p class="_3uLFr _30MBE _1nuia _22U5z">on NerdWallet&#x27;s
                                        secure website</p></div>
                            </div>
                        </td>
                        <td>
                            <div class="_3rMmf _2TgzK"><a class="L5G7w"
                                                          href="https://www.nerdwallet.com/blog/loans/citibank-personal-loan-review/?trk_channel=web&amp;trk_element=hyperlink&amp;trk_location=ProductSummaryTable-rating-link&amp;trk_nldt=undefined&amp;trk_pagetype=roundup&amp;trk_topic=Personal%20Loans&amp;trk_vertical=Loans">
                                <svg viewBox="0 0 14 14" version="1.1"
                                     xmlns="http://www.w3.org/2000/svg" class="_1TR9s">
                                    <defs>
                                        <filter id="outline_selected">
                                            <feFlood flood-color="#00aacc"
                                                     result="base"></feFlood>
                                            <feMorphology result="bigger" in="SourceGraphic"
                                                          operator="dilate"
                                                          radius="1"></feMorphology>
                                            <feColorMatrix result="mask" in="bigger"
                                                           type="matrix"
                                                           values="0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0"></feColorMatrix>
                                            <feComposite result="drop" in="base" in2="mask"
                                                         operator="in"></feComposite>
                                            <feGaussianBlur result="blur" in="drop"
                                                            stdDeviation="1"></feGaussianBlur>
                                            <feBlend in="SourceGraphic" in2="blur"
                                                     mode="normal"></feBlend>
                                        </filter>
                                    </defs>
                                    <g stroke="none" stroke-width="1" fill-rule="evenodd">
                                        <polygon fill="#64666A"
                                                 transform="translate(3.501500, 6.650000) translate(-3.501500, -6.650000) "
                                                 points="6.996 0 5.03 4.63725674 0 5.0730929 3.813 8.38284867 2.674 13.3000002 7.001 10.6979784 7.003 10.6999776"></polygon>
                                        <polygon fill="#64666A"
                                                 transform="translate(10.470000, 6.650000) scale(-1, 1) translate(-10.490000, -6.650000)"
                                                 points="13.9830028 -1.0658141e-14 12.017845 4.63725674 6.98999977 5.0730929 10.8013663 8.38284867 9.66285426 13.3000002 13.9880006 10.6979784 13.9899998 10.6999776"></polygon>
                                    </g>
                                </svg>
                                <p class="_26Nf4 Uk7cV">3.0</p><span
                                    class="_1jytb _1nuia _22U5z">/5</span></a></div>
                            <p class="_3uLFr _1nuia _22U5z">Best for: <!-- -->Bank loans for
                                co-signers</p></td>
                        <td class="_3Zx3Y"><p class="_1hL7v">7.99 - 23.99%</p></td>
                        <td class="_3Zx3Y"><p class="_1hL7v">None</p></td>
                        <td class="_2XJHT"><a class="_3SEyh _31zBK qjkre _2v2FF _1eCRG"
                                              href="https://www.nerdwallet.com/personal-loans/pre-qualify/step-1?trk_channel=web&amp;trk_element=button&amp;trk_location=ProductSummaryTable-MarketplaceApplyNow-MarketplaceReviewLink&amp;trk_nldt=undefined&amp;trk_pagetype=roundup&amp;trk_sectionCategory=ProductSummaryTable__cta&amp;trk_topic=Personal%20Loans&amp;trk_vertical=Loans">
                            <div class="_3jS8m">See my rates</div>
                        </a>
                            <p class="_3uLFr _30MBE _1nuia _22U5z">on NerdWallet&#x27;s
                                secure website</p></td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>
