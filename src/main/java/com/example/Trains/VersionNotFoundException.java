package com.example.Trains;

public class VersionNotFoundException extends RuntimeException {

        private static final long serialVersionUID = 1L;

        public VersionNotFoundException(Long id) {
            super("Could not find Seat " + id);
        }
}
