@PostMapping("/login")
public AuthResponse login(@RequestParam String email,
                          @RequestParam String password) {

    authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(email, password)
    );

    UserDetails userDetails = userDetailsService.loadUserByUsername(email);

    // ✅ FIXED LINE
    String token = jwtUtil.generateToken(userDetails, email);

    return new AuthResponse(token, null, email, null);
}
