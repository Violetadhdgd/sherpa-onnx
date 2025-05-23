// Copyright 2025 Xiaomi Corporation

package com.k2fsa.sherpa.onnx;

public class DenoisedAudio {
    static {
        System.loadLibrary("sherpa-onnx-jni");
    }

    private final float[] samples;
    private final int sampleRate;

    public DenoisedAudio(float[] samples, int sampleRate) {
        this.samples = samples;
        this.sampleRate = sampleRate;
    }

    public int getSampleRate() {
        return sampleRate;
    }

    public float[] getSamples() {
        return samples;
    }

    // return true if saved successfully.
    public boolean save(String filename) {
        return saveImpl(filename, samples, sampleRate);
    }

    private native boolean saveImpl(String filename, float[] samples, int sampleRate);
}
