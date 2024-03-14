// package com.ecommerce_plant.plant.config;
//
// import java.io.IOException;
//
// import org.springframework.web.filter.OncePerRequestFilter;
//
// import jakarta.servlet.FilterChain;
// import jakarta.servlet.ServletException;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;
//
// public class JwtAuthenticationFilter extends OncePerRequestFilter {
//
// @Override
// protected void doFilterInternal(HttpServletRequest request,
// HttpServletResponse response, FilterChain filterChain)
// throws ServletException, IOException {
// String token = extractTokenFromRequest(request);
// // if (token != null && jwtProvider.validateToken(token)) {
// // String username = jwtProvider.getUsernameFromToken(token);
// // UsernamePasswordAuthenticationToken authentication = new
// // UsernamePasswordAuthenticationToken(token, username);
// // SecurityContextHolder.getContext().setAuthentication(authentication);
// }
//
// // filterChain.doFilter(request, response);
// }
//
// private String extractTokenFromRequest(HttpServletRequest request) {
// String bearerToken = request.getHeader("Authorization");
// if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
// return bearerToken.substring(7);
// }
// return null;
// }
// }